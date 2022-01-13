package com.xekz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xekz.base.BaseService;
import com.xekz.bean.User;
import com.xekz.bean.UserScore;
import com.xekz.mapper.UserMapper;
import com.xekz.mapper.UserScoreMapper;
import com.xekz.query.UserQuery;
import com.xekz.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserService extends BaseService<User,Integer> {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserScoreMapper userScoreMapper;


    public Map<String, Object> queryUserByParams(UserQuery userQuery) {
        //实例化map
        Map<String,Object> map = new HashMap<>();
        //开启分页
        PageHelper.startPage(userQuery.getPage(),userQuery.getLimit());
        //查询数据
        List<User> users = userMapper.selectUserByParams(userQuery);
        //遍历一下
        for (User u:users) {
            //密码解密
            u.setUserPwd(String.valueOf(UserIDBase64.decoderUserID(u.getUserPwd())));

            //设会员等级1000,5000,10000
            if(u.getUserScore() < 1000) {
                u.setUserGrade("普通会员");
            }else if(u.getUserScore() >= 1000 && u.getUserScore() < 5000) {
                u.setUserGrade("黄金会员");
            }else if(u.getUserScore() >= 5000 && u.getUserScore() < 10000) {
                u.setUserGrade("钻石会员");
            }else if(u.getUserScore() >= 10000) {
                u.setUserGrade("至尊会员");
            }
        }
        //分页
        PageInfo pageInfo = new PageInfo(users);
        //赋值
        map.put("code",0);
        map.put("msg","操作成功");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        //返回
        return map;
    }

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user) {
        //校验
        //用户名，密码，手机号，身份证信息
        checkParams(user);
        //给默认值
        user.setCreateDate(new Date());
        //密码加密
//        user.setUserPwd(UserIDBase64.encoderUserID(Integer.parseInt(user.getUserPwd())));
        user.setUserPwd(Md5Util.encode(user.getUserPwd()));
        //添加
        AssertUtil.isTrue(userMapper.insertHasKey(user) < 1,"添加失败");
        UserScore us = new UserScore();
        us.setUserId(user.getUserId());
        us.setUserScore(0);
        AssertUtil.isTrue(userScoreMapper.insertUserScore(us) < 1,"插入用户积分失败");
    }

    /**
     * 校验方法
     * @param user
     */
    private void checkParams(User user) {
        //有无id
        User temp = userMapper.selectByIdNo(user.getIdNo());
        if(null == user.getUserId()) {
            //添加
            AssertUtil.isTrue(null != temp ,"此用户已存在");
        }else {
            //修改
            AssertUtil.isTrue(null != temp && !(temp.getUserId().equals(user.getUserId())),"此用户已存在");
        }
        //判断非空
        AssertUtil.isTrue(StringUtils.isBlank(user.getRealName()),"用户名为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"密码不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserTel()),"手机号不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getIdNo()),"身份证信息不能为空");
        //手机号校验
        AssertUtil.isTrue(!PhoneUtil.isMobile(user.getUserTel()),"手机号不合法");
    }

    public User selectByUserId(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        //解密
//        user.setUserPwd(String.valueOf(UserIDBase64.decoderUserID(user.getUserPwd())));

        //返回
        return user;
    }

    public void updateUser(User user) {
        //校验
        checkParams(user);
        //密码加密
        user.setUserPwd(Md5Util.encode(user.getUserPwd()));
        //修改
        AssertUtil.isTrue(userMapper.updateUser(user) < 1,"修改失败");
    }

    /**
     * 删除用户
     * @param ids
     */
    public void deleteByIds(Integer[] ids){
        AssertUtil.isTrue(userMapper.deleteByIds(ids) < ids.length,"操作失败");
        userScoreMapper.deleteScore(ids);
    }


    public User selectById(int id) {
        return userMapper.selectById(id);
    }
}
