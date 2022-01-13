package com.xekz.controller;

import com.xekz.base.BaseController;
import com.xekz.bean.Admin;
import com.xekz.service.AdminService;
import com.xekz.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private AdminService adminService;
    // 登录页面

    @RequestMapping("index")
    public String index() {
        return "index";
    }
    // 系统界面欢迎页
    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    //主页面
    @RequestMapping("main")
    public String main(HttpServletRequest req) {
        //获取当前用户的信息
        int userId = LoginUserUtil.releaseUserIdFromCookie(req);
        //根据用户的id查询用户信息
        Admin admin = adminService.selectByPrimaryKey(userId);
        //存储
        req.setAttribute("Admin",admin);

        //转发
        return "main";

    }
}
