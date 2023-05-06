package com.hqyj.cl.service.impl;
/*逻辑处理接口实现类，查询数据库，处理得到的结果*/
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hqyj.cl.mapper.UserMapper;
import com.hqyj.cl.pojo.User;
import com.hqyj.cl.service.UserService;
import com.hqyj.cl.utils.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
*@Componet用在一般实体
*@Service用在service接口实现类上
*@Controller用在controller类上
 */
@Service
//q: @Service有什么用？
//a: @Service注解是用来标注业务层组件的，当组件不好归类的时候，我们可以使用这个注解进行标注。

public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    //登录
    @Override
    public ResultInfo login(User user) {

        QueryWrapper<User>queryWrapper=new QueryWrapper<>();

        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        //执行查询操作，得到查询结果
        User loginUser=userMapper.selectOne(queryWrapper);
        //判断是否登陆成功
        if(loginUser==null)
            return new ResultInfo(500,"登陆失败");
        return new ResultInfo(200,"登录成功");
    }


    //用户列表
    @Override
    public ResultInfo userList(String username, Integer page, Integer size) {
        //使用mybatis-plusf分页插件,需要构造一个分页插件对象
        Page<User> myPage=new Page<>(page,size);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //like模糊查询使用like()方法
        queryWrapper.like(username!=null&&!"".equals(username),"username",username);
        Page<User> userPage=userMapper.selectPage(myPage,queryWrapper);
        return new ResultInfo(200,"用户查询",userPage);
    }


    //删除用户
    @Override
    public ResultInfo deleteUserByUsername(String username) {
        QueryWrapper<User>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        int delete= userMapper.delete(queryWrapper);
        return new ResultInfo(200,"删除成功",delete);
    }


    //修改用户
    @Override
    public ResultInfo updateUserByUsername(User user) {
        QueryWrapper<User>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        int update= userMapper.update(user,queryWrapper);
        return new ResultInfo(200,"修改成功",update);
    }


    //新增用户
    @Override
    public ResultInfo insertUser(User user) {
        int insert=userMapper.insert(user);
        return new ResultInfo(200,"新增用户",insert);
    }
}
