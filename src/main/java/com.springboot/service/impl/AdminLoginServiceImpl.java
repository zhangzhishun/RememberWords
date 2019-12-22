package com.springboot.service.impl;

import com.springboot.dao.AdminDao;
import com.springboot.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    AdminDao adminDaoImpl;

    @Override
    public boolean login(String adminName, String adminPassword) {
        return adminDaoImpl.login(adminName,adminPassword);
    }
}
