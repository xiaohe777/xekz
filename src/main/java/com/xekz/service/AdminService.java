package com.xekz.service;

import com.xekz.base.BaseService;
import com.xekz.bean.Admin;
import com.xekz.mapper.AdminMapper;
import com.xekz.model.AdminModel;
import com.xekz.utils.AssertUtil;
import com.xekz.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService extends BaseService<Admin, Integer> {

    @Resource
    private AdminMapper adminMapper;


    public AdminModel adminLogin(String userName, String userPwd) {
        checkUserLoginParam(userName, userPwd);
        //用户存在
        Admin temp = adminMapper.selectUserByName(userName);
        AssertUtil.isTrue(temp == null, "用户不存在");
        //用户密码是否正确
        checkUserPwd(userPwd, temp.getUserPwd());
        //构建返回对象

        return builderUserInfo(temp);
    }

    //返回对象
    private AdminModel builderUserInfo(Admin temp) {
        //实例化
        AdminModel userModel = new AdminModel();
        userModel.setId(temp.getUserId());
        userModel.setUserName(temp.getUserName());
        return userModel;
    }

    //校验用户名密码
    private void checkUserLoginParam(String userName, String userPwd) {
        //用户非空
        AssertUtil.isTrue(StringUtils.isBlank(userName), "用户名不能为空");
        //用户密码非空
        AssertUtil.isTrue(StringUtils.isBlank(userPwd), "密码不能为空");
    }

    private void checkUserPwd(String userPwd, String userPwd1) {
        System.out.println(userPwd);
        System.out.println(userPwd1);
        //加密
//        userPwd = Md5Util.encode(userPwd);
        //加密的密码呵数据库中密码对比
        AssertUtil.isTrue(!userPwd.equals(userPwd1), "密码输入不正确");
    }

    //修改密码的校验方法
    public void changeUserPwd(Integer userId, String oldPassword, String newPassword, String confirmPwd) {

        //用户登录了修改，userId
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        System.out.println(admin);
        //密码验证
        checkPasswordParams(admin, oldPassword, newPassword, confirmPwd);

        //加密修改密码

        admin.setUserPwd(Md5Util.encode(newPassword));

        //确认密码修改是否成功
        AssertUtil.isTrue(adminMapper.updateByPrimaryKeySelective(admin) < 1, "修改失败了");
    }

    //修改密码的验证的新方法
    private void checkPasswordParams(Admin admin, String oldPassword, String newPassword, String confirmPwd) {
        //用户是否存在
        AssertUtil.isTrue(admin == null, "用户未登录或者不存在");
        //原始密码非空
        AssertUtil.isTrue(StringUtils.isBlank(oldPassword), "请输入原始密码");
        //原始密码是否正确
        AssertUtil.isTrue(!(admin.getUserPwd().equals(Md5Util.encode(oldPassword))), "原始密码不正确");
        //新密码非空
        AssertUtil.isTrue(StringUtils.isBlank(newPassword), "新密码不能为空");
        //新密码不能和原始密码一致
        AssertUtil.isTrue(newPassword.equals(oldPassword), "新密码和原始密码不能相同");
        //确认密码非空
        AssertUtil.isTrue(StringUtils.isBlank(confirmPwd), "确认密码不能为空");
        //确认密码和新密码一致
        AssertUtil.isTrue(!confirmPwd.equals(newPassword), "确认密码和新密码要一致");
    }

}
