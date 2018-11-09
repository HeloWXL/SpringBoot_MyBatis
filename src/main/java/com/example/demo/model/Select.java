package com.example.demo.model;

public class Select {
    private Integer selectId;

    private String selectName;

    private String selectA;

    private String selectB;

    private String selectC;

    private String selectD;

    private String selectAnswer;

    private Integer tid;

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName == null ? null : selectName.trim();
    }

    public String getSelectA() {
        return selectA;
    }

    public void setSelectA(String selectA) {
        this.selectA = selectA == null ? null : selectA.trim();
    }

    public String getSelectB() {
        return selectB;
    }

    public void setSelectB(String selectB) {
        this.selectB = selectB == null ? null : selectB.trim();
    }

    public String getSelectC() {
        return selectC;
    }

    public void setSelectC(String selectC) {
        this.selectC = selectC == null ? null : selectC.trim();
    }

    public String getSelectD() {
        return selectD;
    }

    public void setSelectD(String selectD) {
        this.selectD = selectD == null ? null : selectD.trim();
    }

    public String getSelectAnswer() {
        return selectAnswer;
    }

    public void setSelectAnswer(String selectAnswer) {
        this.selectAnswer = selectAnswer == null ? null : selectAnswer.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}