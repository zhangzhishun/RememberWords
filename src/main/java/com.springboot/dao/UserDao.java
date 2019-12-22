package com.springboot.dao;

import com.springboot.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserDao {
    /*
    * 通过userName获取User
    * */
    Map<String,Object> getUserByName(String userName);

    /*
     * 通过userId获取User
     * */
    Map<String,Object> getUserById(String userId);

    /*
     * 通过userName获取User
     * */
    List<Map<String,Object>> getAllUser();

    /*
     * 更新用户账号
     * */
    boolean updateUser(User newUser);

    /*
     * 更新用户账号的密码
     * */
    boolean updateUserPassword(String userId,String newPassword);

    /*
     * 删除用户账号
     * */
    boolean delUserByUserId(String userId);

    /*
     * 添加账户
     * 返回值
     * 1：添加成功
     * 0：网络异常
     * -1：用户已存在
     * */
    Integer addUser(String userName,String userPassword,String userSex);
}
