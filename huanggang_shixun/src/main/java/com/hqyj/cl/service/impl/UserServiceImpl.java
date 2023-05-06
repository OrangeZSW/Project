package com.hqyj.cl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hqyj.cl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hqyj.cl.pojo.User;
import com.hqyj.cl.service.UserService;
import com.hqyj.cl.utils.ResultInfo;

/*
@Component、类
@Service、一般类
@Repository 接口实现
@Controller 控制类
spring注入
 */
//实现逻辑
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultInfo login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUserName());
        queryWrapper.eq("password", user.getPassword());
        User loginUser = userMapper.selectOne(queryWrapper);
        if (loginUser == null) {
            return new ResultInfo(500, "登录失败");
        } else {
            return new ResultInfo(200, "登录采访稿");
        }
    }

    @Override
    public ResultInfo userList(String username, Integer page, Integer size) {
        Page<User> myPage = new Page<>(page, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(username != null && !"".equals(username), "username", username);
        Page<User> userPage = userMapper.selectPage(myPage, queryWrapper);
        return new ResultInfo(200, "用户查询", userPage);
    }

    @Override
    public ResultInfo deleteUserByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        int delete = userMapper.delete(queryWrapper);
        return new ResultInfo(200, "删除用户", delete);
    }

    @Override
    public ResultInfo updateUserByName(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUserName());
        int update = userMapper.update(user, queryWrapper);
        return new ResultInfo(200, "修改用户", update);
    }

    @Override
    public ResultInfo insertUser(User user) {
        int insert = userMapper.insert(user);
        return new ResultInfo(200, "新增用户 ", insert);
    }
}
