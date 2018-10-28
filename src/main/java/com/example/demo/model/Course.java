package com.example.demo.model;

import java.util.Date;

public class Course {
    private Integer cid;

    private String cname;

    private String cpicture;

    private Date createtime;

    private Integer tid;

    private String cintroduce;

    private Integer cpingfen;

    private String cvideo;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCpicture() {
        return cpicture;
    }

    public void setCpicture(String cpicture) {
        this.cpicture = cpicture == null ? null : cpicture.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCintroduce() {
        return cintroduce;
    }

    public void setCintroduce(String cintroduce) {
        this.cintroduce = cintroduce == null ? null : cintroduce.trim();
    }

    public Integer getCpingfen() {
        return cpingfen;
    }

    public void setCpingfen(Integer cpingfen) {
        this.cpingfen = cpingfen;
    }

    public String getCvideo() {
        return cvideo;
    }

    public void setCvideo(String cvideo) {
        this.cvideo = cvideo == null ? null : cvideo.trim();
    }
}