package com.springboot.dao;

import com.springboot.domain.Notes;
import com.springboot.domain.Words;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface WordsDao {
    /*
     * 获取单词
     * */
    List<Map<String,Object>> getWordsAndNotesByWordsId(String wordsId);

    /*
     * 增加单词
     * */
    String addWords(String wordsSpell,String wordInterpretation);

    /*
     * 删除单词
     * */
    boolean delWords(String wordsId);

    /*
     * 修改单词
     * */
    boolean updateWords(Words words);
}
