package com.hqyj.cl.controller;

import com.hqyj.cl.pojo.User;
import com.hqyj.cl.service.UserService;
import com.hqyj.cl.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*控制器
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    //登录：http://localhost:8080/user/login
    @RequestMapping("/login")
    public ResultInfo login(User user){
        return userService.login(user);
    }

    //列表：http://localhost:8080/user/userList
    @RequestMapping("/userList")
    public ResultInfo userList(String username,Integer page,Integer size){
        return userService.userList(username,page,size);
    }

    //删除：http://localhost:8080/user/deleteUserByUsername
    @RequestMapping("/deleteUserByUsername")
    public ResultInfo deleteUserByUsername(String username){
        return userService.deleteUserByUsername(username);
    }

    //修改：http://localhost:8080/user/updateUserByUsername
    @RequestMapping("/updateUserByUsername")
    public ResultInfo updateUserByUsername(User user){
        return userService.updateUserByUsername(user);
    }

    //新增：http://localhost:8080/user/insertUser
    @RequestMapping("/insertUser")
    public ResultInfo insertUser(User user){
        return userService.insertUser(user);
    }


}
