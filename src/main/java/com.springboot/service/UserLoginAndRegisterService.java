package com.springboot.service;

import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserLoginAndRegisterService {
    /*
    * 用户登录
    * */
    boolean login(String userName,String userPassword);

    /*
     * 用户注册
     * 返回值
     * 1：添加成功
     * 0：网络异常
     * -1：用户已存在
     * */
    Integer userRegister(String userName,String userPassword,String userSex);
}
