package com.hqyj.cl.service;

import com.hqyj.cl.pojo.User;
import com.hqyj.cl.utils.ResultInfo;

public interface UserService {
    ResultInfo login(User user);
    ResultInfo userList(String username,Integer page,Integer size);
    ResultInfo deleteUserByUsername(String username);
    ResultInfo updateUserByUsername(User user);
    ResultInfo insertUser(User user);

}
