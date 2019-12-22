package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Words {
    private String wordsId;
    private String wordsSpell;
    private String wordInterpretation;

    public String getWordsId() {
        return wordsId;
    }

    public void setWordsId(String wordsId) {
        this.wordsId = wordsId;
    }

    public String getWordsSpell() {
        return wordsSpell;
    }

    public void setWordsSpell(String wordsSpell) {
        this.wordsSpell = wordsSpell;
    }

    public String getWordInterpretation() {
        return wordInterpretation;
    }

    public void setWordInterpretation(String wordInterpretation) {
        this.wordInterpretation = wordInterpretation;
    }
}
