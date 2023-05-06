package com.hqyj.cl.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

import java.security.PublicKey;

/**
 * 类说明
 *
 * @author:chenlei
 * @date:2023/3/17
 * @description: 和表 user 对应的实体类
 */
public class User {
    // user_id
    private Integer userId; // 数据库表中字段使用下划线命名，Java 实体类中的成员变量使用小
    // username
    private String username;
    // password
    private String password;
    // age
    private Integer age;
    // gender
    private String gender;
    // user_state
    @TableField
    private Integer userState;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", userState=" + userState +
                '}';
    }
}