package com.springboot.dao.impl;

import com.springboot.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    JdbcTemplate jdbcTemplateImpl;

    @Override
    public Map<String, Object> getAdminByName(String adminName) {
        String sql = "SELECT * FROM admin WHERE adminName=?";
        Map<String, Object> result = null;
        try{
            result = jdbcTemplateImpl.queryForMap(sql,adminName);
        }catch (EmptyResultDataAccessException ev){
            return null;
        }
        for (Map.Entry<String,Object> re : result.entrySet()) {
            System.out.println(re);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAdminById(String adminId) {
        String sql = "SELECT * FROM admin WHERE adminId=?";
        Map<String, Object> result = null;
        try{
            result = jdbcTemplateImpl.queryForMap(sql,adminId);
        }catch (EmptyResultDataAccessException ev){
            return null;
        }
        for (Map.Entry<String,Object> re : result.entrySet()) {
            System.out.println(re);
        }
        return result;
    }

    /** 更新密码 */
    @Override
    public boolean updateAdminPassword(String adminId, String newPassword) {
        return jdbcTemplateImpl.update("UPDATE admin SET adminPassword = ? WHERE adminId = ?",newPassword, adminId)>0;
    }

    @Override
    public boolean login(String adminName, String adminPassword) {
        Map<String, Object> result = null;
        try{
            result = jdbcTemplateImpl.queryForMap("SELECT * FROM admin WHERE adminName=? AND adminPassword=?",adminName,adminPassword);
        }catch (EmptyResultDataAccessException ev){
            return false;
        }
        for (Map.Entry<String,Object> re : result.entrySet()) {
            System.out.println(re);
        }
        return true;
    }
}
