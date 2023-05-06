package com.hqyj.cl.service;

import com.hqyj.cl.pojo.User;
import com.hqyj.cl.utils.ResultInfo;

public interface UserService {
    //登录
    ResultInfo login(User user);

    //查询
    ResultInfo userList(String username, Integer page, Integer size);

    //删除
    ResultInfo deleteUserByName(String username);

    //修改
    ResultInfo updateUserByName(User user);

    //注册
    ResultInfo insertUser(User user);


}
