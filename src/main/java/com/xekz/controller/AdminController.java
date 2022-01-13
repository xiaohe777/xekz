package com.xekz.controller;

import com.xekz.base.BaseController;
import com.xekz.base.ResultInfo;
import com.xekz.bean.Admin;
import com.xekz.exceptions.ParamsException;
import com.xekz.model.AdminModel;
import com.xekz.service.AdminService;
import com.xekz.utils.CookieUtil;
import com.xekz.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Autowired
    public AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo say(Admin admin) {
        System.out.println(admin.toString());
        ResultInfo resultInfo = new ResultInfo();


        AdminModel adminModel = adminService.adminLogin(admin.getUserName(), admin.getUserPwd());

        resultInfo.setResult(adminModel);

        return resultInfo;
    }


    @PostMapping("updatePwd")
    @ResponseBody
    public ResultInfo updatePwd(HttpServletRequest req, String oldPassword, String newPassword, String confirmPwd) {
        ResultInfo resultInfo = new ResultInfo();
        //获取Cookie中的userId
        //int userId = LoginUserUtil.releaseUserIdFromCookie(req);
        //修改密码操作
        int userId = (Integer.parseInt(CookieUtil.getCookieValue(req, "userId")));
        adminService.changeUserPwd(userId, oldPassword, newPassword, confirmPwd);
        return resultInfo;
    }

    @RequestMapping("toPasswordPage")
    public String updatePwd() {
        return "admin/password";
    }
}
