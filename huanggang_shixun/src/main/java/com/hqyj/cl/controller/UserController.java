package com.hqyj.cl.controller;


import com.hqyj.cl.pojo.User;
import com.hqyj.cl.service.UserService;
import com.hqyj.cl.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")//请求路径
public class UserController {
    @Autowired
    private UserService userService;

    //http://localhost:8080/user/login
    @RequestMapping("/login")
    public ResultInfo login(User user) {
        return userService.login(user);
    }

    @RequestMapping("/userlist")
    //查询
    public ResultInfo userList(String username, Integer page, Integer size) {
        return userService.userList(username, page, size);
    }

    @RequestMapping("/deleteUserByName")
    //删除
    public ResultInfo deleteUserByName(String username) {
        return userService.deleteUserByName(username);
    }

    @RequestMapping("/updateUserByName")
    //修改
    public ResultInfo updateUserByName(User user) {
        return userService.updateUserByName(user);
    }

    @RequestMapping("/insertUse")
    //注册
    public ResultInfo insertUser(User user) {
        return userService.insertUser(user);
    }

}
