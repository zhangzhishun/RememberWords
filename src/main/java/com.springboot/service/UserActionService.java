package com.springboot.service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserActionService {
    /*
    * 添加单词
    * */
    boolean addWordsService(String userId, String wordsSpell, String wordInterpretation);

    /*
     * 根据用户名获取用户ID
     * */
    String getUserIdByName(String userName);

    /*
     * 获取指定用户的单词记录
     * */
    List<Map<String,Object>> getNotesAndWordsByUserId(String userId);

    /*
     * 删除指定的单词以及记录
     * */
    boolean delNotesAndWordsByWordsId(String wordsId);

    /*
     * 更新用户密码
     * 返回值：
     * -1：原密码错误
     * 0：更新语句执行错误
     * 1：更新成功
     * */
    Integer updateUserPassword(String userId, String prUserPassword, String newPassword);

    /*
     * 修改单词
     * */
    boolean updateWords(String wordsId, String wordsSpell, String wordInterpretation);
}
