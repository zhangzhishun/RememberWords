package com.springboot.service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminActionService {

    /*
     * 根据用户名获取用户ID
     * */
    String getAdminIdByName(String adminName);

    /*
     * 管理员查看所有单词
     * */
    List<Map<String,Object>> getAllNotesAndWords();

    /*
     * 更新管理员密码
     * 返回值：
     * -1：原密码错误
     * 0：更新语句执行错误
     * 1：更新成功
     * */
    Integer updateAdminPassword(String adminId,String prAdminPassword,String newAdminPassword);

    /*
     * 通过userName获取User
     * */
    List<Map<String,Object>> getAllUser();

    /*
     * 更新用户
     * -1：用户名冲突
     * 0：事务执行错误
     * 1：更新成功
     * */
    Integer updateUser(String updateUserId, String newUserName, String newUserPassword,String newUserSex);

    /*
     * 删除用户账号
     * */
    boolean delUserByUserId(String userId);
}
