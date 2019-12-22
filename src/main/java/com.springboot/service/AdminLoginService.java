package com.springboot.service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminLoginService {
    /*
     * 管理员登录
     * */
    boolean login(String adminName,String adminPassword);
}
