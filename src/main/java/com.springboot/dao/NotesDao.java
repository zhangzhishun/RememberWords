package com.springboot.dao;

import com.springboot.domain.Notes;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface NotesDao {

    /*
     * 获取记录
     * */
    List<Map<String,Object>> getNotesAndWordsByuserId(String userId);

    /*
    * 增加记录
    * */
    boolean addNotes(String userId,String wordsId);

    /*
     * 删除记录
     * */
    boolean delNotes(String notesId);

    /*
     * 修改记录
     * */
    boolean updateNotes(Notes notes);
}
