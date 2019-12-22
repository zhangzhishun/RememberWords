package com.springboot.service.impl;

import com.springboot.dao.NotesDao;
import com.springboot.dao.UserDao;
import com.springboot.dao.WordsDao;
import com.springboot.domain.Words;
import com.springboot.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserActionServiceImpl implements UserActionService {
    @Autowired
    WordsDao wordsDaoImpl;
    @Autowired
    NotesDao notesDaoImpl;
    @Autowired
    UserDao userDaoImpl;

    @Override
    public boolean addWordsService(String userId, String wordsSpell, String wordInterpretation) {
        String wordsId = wordsDaoImpl.addWords(wordsSpell,wordInterpretation);
        System.out.println("wordsId::"+wordsId);
        return notesDaoImpl.addNotes(userId,String.valueOf(wordsId));
    }

    @Override
    public String getUserIdByName(String userName) {
        return userDaoImpl.getUserByName(userName).get("userId").toString();
    }

    @Override
    public List<Map<String, Object>> getNotesAndWordsByUserId(String userId) {
        return notesDaoImpl.getNotesAndWordsByuserId(userId);
    }

    @Override
    public boolean delNotesAndWordsByWordsId(String wordsId) {
        return wordsDaoImpl.delWords(wordsId);
    }

    @Override
    public Integer updateUserPassword(String userId, String prUserPassword, String newPassword) {
        if(userDaoImpl.getUserById(userId).get("userPassword").equals(prUserPassword)){
            userDaoImpl.updateUserPassword(userId,newPassword);
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public boolean updateWords(String wordsId, String wordsSpell, String wordInterpretation) {
        Words words = new Words();
        words.setWordsId(wordsId);
        words.setWordsSpell(wordsSpell);
        words.setWordInterpretation(wordInterpretation);
        return wordsDaoImpl.updateWords(words);
    }

}
