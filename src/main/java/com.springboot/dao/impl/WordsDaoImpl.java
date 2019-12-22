package com.springboot.dao.impl;

import com.springboot.dao.WordsDao;
import com.springboot.domain.Words;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class WordsDaoImpl implements WordsDao {
    @Autowired
    JdbcTemplate jdbcTemplateImpl;

    @Override
    public List<Map<String, Object>> getWordsAndNotesByWordsId(String wordsId) {
        return jdbcTemplateImpl.queryForList("SELECT * FROM words INNER JOIN notes on notes.wordsId = words.wordsId " +
                "AND words.wordsId = ?",wordsId);
    }

    @Override
    public String addWords(String wordsSpell, String wordInterpretation) {
        String sql = "INSERT INTO words VALUES(null,'" + wordsSpell + "','" + wordInterpretation + "')";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplateImpl.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            return ps;
        }, keyHolder);
        Number key = keyHolder.getKey();
        if(key != null){
            return String.valueOf(key.intValue());
        }
        return "0";
    }

    @Override
    public boolean delWords(String wordsId) {
        return jdbcTemplateImpl.update("DELETE FROM words WHERE wordsId = ?", wordsId)>0;
    }

    @Override
    public boolean updateWords(Words words) {
        return jdbcTemplateImpl.update("UPDATE words SET wordsSpell = ?,wordInterpretation = ? WHERE wordsId = ?",words.getWordsSpell(),words.getWordInterpretation(),words.getWordsId() )>0;
    }
}
