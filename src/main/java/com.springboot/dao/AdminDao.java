package com.springboot.dao;

import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminDao {

    /*
     * 通过userName获取User
     * */
    Map<String,Object> getAdminByName(String adminName);

    /*
     * 通过userId获取User
     * */
    Map<String,Object> getAdminById(String adminId);

    /*
     * 管理员登录
     * */
    boolean login(String adminName,String adminPassword);

    /*
     * 更新管理员账号的密码
     * */
    boolean updateAdminPassword(String adminId,String newPassword);
}
