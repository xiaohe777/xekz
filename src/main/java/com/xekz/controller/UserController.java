package com.xekz.controller;

import com.xekz.base.BaseController;
import com.xekz.base.ResultInfo;
import com.xekz.bean.User;
import com.xekz.query.UserQuery;
import com.xekz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index (){
        return "user/user";
    }

    /**
     * 查看所有用户信息
     * @param userQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(UserQuery userQuery){
        return userService.queryUserByParams(userQuery);
    }

    @RequestMapping("addOrUpdateUserPage")
    public String addOrUpdateUserPage(Integer userId, Model model){
        if(userId != null) {
            //根据id查询用户
            User user = userService.selectByUserId(userId);
            //增加属性
            model.addAttribute("user",user);
        }
        return "user/add_update";
    }

    /**
     *添加用户
     * @param user
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(User user){
        //调用
        userService.insertUser(user);
        //返回
        return success("操作成功");
    }

    /**
     *修改用户
     * @param user
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(User user){
        //调用
        System.out.println(user);
        userService.updateUser(user);
        //返回
        return success("操作成功");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(Integer[] ids){
        userService.deleteByIds(ids);
        return success("操作成功");
    }
}
