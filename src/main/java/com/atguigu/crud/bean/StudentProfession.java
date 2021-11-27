package com.atguigu.crud.bean;

public class StudentProfession {
    private String studentid;

    private String professionid;
    public professioninfo professioninfo;
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getProfessionid() {
        return professionid;
    }

    public void setProfessionid(String professionid) {
        this.professionid = professionid == null ? null : professionid.trim();
    }
}