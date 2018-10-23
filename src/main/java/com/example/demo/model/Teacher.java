package com.example.demo.model;

public class Teacher {
    private Integer tid;

    private String tname;

    private Integer tage;

    private String tsex;

    private String timage;

    private String tintroduce;

    private String tmajor;

    private Integer rid;

    private String tpassword;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex == null ? null : tsex.trim();
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage == null ? null : timage.trim();
    }

    public String getTintroduce() {
        return tintroduce;
    }

    public void setTintroduce(String tintroduce) {
        this.tintroduce = tintroduce == null ? null : tintroduce.trim();
    }

    public String getTmajor() {
        return tmajor;
    }

    public void setTmajor(String tmajor) {
        this.tmajor = tmajor == null ? null : tmajor.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword == null ? null : tpassword.trim();
    }
}