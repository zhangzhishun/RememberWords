package com.springboot.service.impl;

import com.springboot.dao.UserDao;
import com.springboot.service.UserLoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserLoginAndRegisterServiceImpl implements UserLoginAndRegisterService {
    @Autowired
    UserDao userDaoImpl;

    @Override
    public boolean login(String userName, String userPassword) {
        Map<String, Object> user = userDaoImpl.getUserByName(userName);
        if(user!=null && userPassword.equals(user.get("userPassword"))){
            System.out.println(user.get("userPassword"));
            return true;
        }
        return false;
    }

    @Override
    public Integer userRegister(String userName, String userPassword, String userSex) {
        return userDaoImpl.addUser(userName,userPassword,userSex);
    }

}
