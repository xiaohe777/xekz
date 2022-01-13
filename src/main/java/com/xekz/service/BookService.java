package com.xekz.service;

import com.xekz.base.BaseService;
import com.xekz.bean.Book;
import com.xekz.bean.CaterBook;
import com.xekz.mapper.BookMapper;
import com.xekz.mapper.CaterBookMapper;
import com.xekz.mapper.CateringMapper;
import com.xekz.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BookService extends BaseService<Book,Integer> {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private CateringMapper cateringMapper;

    @Resource
    private CaterBookMapper caterBookMapper;


    /***
     *  密码:加密
     * 三.添加是否成功
     * @param book
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBook(Book book){
        //用户名唯一
        //验证是否成功
        AssertUtil.isTrue(insertSelective(book)<1,"添加失败");

        relationCaterBook(book.getBookId(),book.getCateringIds());
    }
    /**
     * 操作中间表
     * @param bookId 用户id
     * @param cateringIds 角色id
     */
    private void relationCaterBook(Integer bookId, String cateringIds) {
        //准备集合存储对象
        List<CaterBook> caterlist = new ArrayList<>();
        //userId,roleId
        AssertUtil.isTrue(StringUtils.isBlank(cateringIds),"请选择菜品信息");
        //统计当前订单有多少菜
        int count = caterBookMapper.countBookCateringNum(bookId);
        //删除当前用户的角色
        if (count>0){
            AssertUtil.isTrue(caterBookMapper.deleteBookCaterByBookId(bookId)!=count,"删除订单失败");
        }
        //删除原来的菜
        String[] CaterStrId = cateringIds.split(",");
        //遍历
        for (String rid:CaterStrId){
            //准备对象
            CaterBook caterBook = new CaterBook();
            caterBook.setBookId(bookId);
            caterBook.setCateringId(rid);
            caterBook.setCreateDate(new Date());
            //存放到集合
            caterlist.add(caterBook);
        }
        //批量添加
        AssertUtil.isTrue(caterBookMapper.insertBatch(caterlist)!=caterlist.size(),"用户角色分配失败");
    }
    /**
     * 一.验证:
     * 当前用户ID存在,否则无法修改
     *  1:用户名非空唯一
     *  2:邮箱非空
     *  3:手机号非空,格式正确
     * 二.设定默认值
     *  is_valid=1
     *  updateDate 系统时间
     * 三.添加是否成功
     * @param book
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeBook(Book book){
        //根据ID获取用户信息
        Book temp = bookMapper.selectByPrimaryKey(book.getBookId());
        //判断
        AssertUtil.isTrue(temp==null,"您要修改的订单不存在");
        //用户名唯一
        Book temp2 = bookMapper.selectBookById(book.getBookId());
        AssertUtil.isTrue(temp2!=null && !(temp2.getBookId().equals(book.getBookId())),"订单已存在");
        //设定默认值
        book.setBookTime(new Date());
        //判断修改是否成功
        AssertUtil.isTrue(updateByPrimaryKeySelective(book)<1,"修改失败");
        relationCaterBook(book.getBookId(),book.getCateringIds());
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void removeUserIds(Integer[] ids){
        AssertUtil.isTrue(ids==null||ids.length==0,"请选择删除的数据");

        //判断删除成功与否
        AssertUtil.isTrue(bookMapper.deleteBatch(ids)<1,"删除失败");

    }

    public void addCaterBook(CaterBook caterBook) {
        if(null != caterBook.getBookId()) {
            //修改
            System.out.println(caterBook);
            AssertUtil.isTrue(caterBook.getRoomId() == null,"房间名不能为空");
//            caterBook.setCreateDate(new Date());
            caterBookMapper.updateCaterBook(caterBook);
            return;
        }
        caterBook.setCreateDate(new Date());
        AssertUtil.isTrue(caterBookMapper.addCaterBook(caterBook) < 1,"操作失败");
    }

    public Map<String,Object> selectAll() {
        Map<String,Object> map = new HashMap<>();

        map.put("code",0);
        map.put("msg","success");
        map.put("data",bookMapper.selectAll());


        return map;
    }

    public CaterBook selectByBookId(Integer bookId) {
        return caterBookMapper.selectByBookId(bookId);
    }
}
