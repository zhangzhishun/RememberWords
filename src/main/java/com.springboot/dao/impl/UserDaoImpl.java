package com.springboot.dao.impl;

import com.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplateImpl;

    @Override
    public Map<String, Object> getUserByName(String userName) {
        String sql = "SELECT * FROM user WHERE userName=?";
        Map<String, Object> result = null;
        try{
            result = jdbcTemplateImpl.queryForMap(sql,userName);
        }catch (EmptyResultDataAccessException ev){
            return null;
        }
        for (Map.Entry<String,Object> re : result.entrySet()) {
            System.out.println(re);
        }
        return result;
    }

    @Override
    public Map<String, Object> getUserById(String userId) {
        String sql = "SELECT * FROM user WHERE userId=?";
        Map<String, Object> result = null;
        try{
            result = jdbcTemplateImpl.queryForMap(sql,userId);
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
    public boolean updateUserPassword(String userId, String newPassword) {
        return jdbcTemplateImpl.update("UPDATE user SET userPassword = ? WHERE userId = ?",newPassword, userId)>0;
    }
}
