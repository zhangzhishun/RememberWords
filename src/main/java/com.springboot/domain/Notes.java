package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Notes {
    private String notesId;
    private String userId;
    private String wordsId;
    private String notesTime;

    public String getNotesId() {
        return notesId;
    }

    public void setNotesId(String notesId) {
        this.notesId = notesId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWordsId() {
        return wordsId;
    }

    public void setWordsId(String wordsId) {
        this.wordsId = wordsId;
    }

    public String getNotesTime() {
        return notesTime;
    }

    public void setNotesTime(String notesTime) {
        this.notesTime = notesTime;
    }
}
