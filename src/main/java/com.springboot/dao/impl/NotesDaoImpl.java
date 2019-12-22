package com.springboot.dao.impl;

import com.springboot.dao.NotesDao;
import com.springboot.domain.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class NotesDaoImpl implements NotesDao {
    @Autowired
    JdbcTemplate jdbcTemplateImpl;

    @Override
    public List<Map<String,Object>> getNotesAndWordsByuserId(String userId) {
        return jdbcTemplateImpl.queryForList("SELECT * FROM words INNER JOIN notes on notes.wordsId = words.wordsId " +
                "AND notes.userId = ?",userId);
    }

    @Override
    public List<Map<String,Object>> getAllNotesAndWords() {
        return jdbcTemplateImpl.queryForList("SELECT * FROM words INNER JOIN notes on notes.wordsId = words.wordsId");
    }

    @Override
    public boolean addNotes(String userId, String wordsId) {
        return jdbcTemplateImpl.update("INSERT INTO notes(userId,wordsId) VALUES(?,?)", userId, wordsId)>0;
    }

    @Override
    public boolean delNotes(String notesId) {
        return jdbcTemplateImpl.update("DELETE FROM notes WHERE notesId = ?", notesId)>0;
    }

    @Override
    public boolean updateNotes(Notes notes) {
        return false;
    }
}
