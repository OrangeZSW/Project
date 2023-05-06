package com.hqyj.cl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    private Integer status; // 状态码
    private String msg; // 提示信息
    private Object data; // 返回数据

    // 定义一个两个参数的构造函数，方法重载
    public ResultInfo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}