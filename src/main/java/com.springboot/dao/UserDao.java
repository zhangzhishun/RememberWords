package com.springboot.dao;

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
     * 更新用户账号的密码
     * */
    boolean updateUserPassword(String userId,String newPassword);
}
