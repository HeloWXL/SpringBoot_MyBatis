package com.example.demo.model;

public class Blank {
    private Integer blankId;

    private String blankName;

    private String blankQuestion;

    private String blankAnswer;

    private Integer tid;

    public Integer getBlankId() {
        return blankId;
    }

    public void setBlankId(Integer blankId) {
        this.blankId = blankId;
    }

    public String getBlankName() {
        return blankName;
    }

    public void setBlankName(String blankName) {
        this.blankName = blankName == null ? null : blankName.trim();
    }

    public String getBlankQuestion() {
        return blankQuestion;
    }

    public void setBlankQuestion(String blankQuestion) {
        this.blankQuestion = blankQuestion == null ? null : blankQuestion.trim();
    }

    public String getBlankAnswer() {
        return blankAnswer;
    }

    public void setBlankAnswer(String blankAnswer) {
        this.blankAnswer = blankAnswer == null ? null : blankAnswer.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}