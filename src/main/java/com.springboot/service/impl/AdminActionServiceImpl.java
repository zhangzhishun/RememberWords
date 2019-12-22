package com.springboot.service.impl;

import com.springboot.dao.AdminDao;
import com.springboot.dao.NotesDao;
import com.springboot.dao.UserDao;
import com.springboot.domain.User;
import com.springboot.service.AdminActionService;
import com.springboot.service.AdminLoginService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminActionServiceImpl implements AdminActionService {
    @Autowired
    NotesDao notesDaoImpl;
    @Autowired
    AdminDao adminDaoImpl;
    @Autowired
    UserDao userDaoImpl;

    @Override
    public List<Map<String, Object>> getAllNotesAndWords() {
        return notesDaoImpl.getAllNotesAndWords();
    }

    @Override
    public String getAdminIdByName(String adminName) {
        return adminDaoImpl.getAdminByName(adminName).get("adminId").toString();
    }

    @Override
    public Integer updateAdminPassword(String adminId, String prAdminPassword, String newAdminPassword) {
        if(adminDaoImpl.getAdminById(adminId).get("adminPassword").equals(prAdminPassword)){
            adminDaoImpl.updateAdminPassword(adminId,newAdminPassword);
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public List<Map<String, Object>> getAllUser() {
        return userDaoImpl.getAllUser();
    }

    @Override
    public Integer updateUser(String updateUserId, String newUserName, String newUserPassword, String newUserSex) {
        /**
         * 如果数据库存在这个新的用户名  而且新的用户名的ID不是被修改用户的ID
         * 那么有一个用户的用户名和这个新用户名一样
         * */
        if(userDaoImpl.getUserByName(newUserName)!=null && (!userDaoImpl.getUserByName(newUserName).get("userId").toString().equals(updateUserId)) ){
            return -1;
        }else{
            User newUser = new User();
            newUser.setUserId(updateUserId);
            newUser.setUserName(newUserName);
            newUser.setUserPassword(newUserPassword);
            newUser.setUserSex(newUserSex);
            if(userDaoImpl.updateUser(newUser)){
                return 1;
            }else{
                return 0;
            }
        }
    }

    @Override
    public boolean delUserByUserId(String userId) {
        return userDaoImpl.delUserByUserId(userId);
    }
}
