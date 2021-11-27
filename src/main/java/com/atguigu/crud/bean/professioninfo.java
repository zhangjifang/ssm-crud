package com.atguigu.crud.bean;

public class professioninfo {
    private String professionid;

    private String professionname;

    private String professionperson;

    private String professiondes;

    private String professionintrodue;

    private Integer year;

    private Integer number;

    public String getProfessionid() {
        return professionid;
    }

    public void setProfessionid(String professionid) {
        this.professionid = professionid == null ? null : professionid.trim();
    }

    public String getProfessionname() {
        return professionname;
    }

    public void setProfessionname(String professionname) {
        this.professionname = professionname == null ? null : professionname.trim();
    }

    public String getProfessionperson() {
        return professionperson;
    }

    public void setProfessionperson(String professionperson) {
        this.professionperson = professionperson == null ? null : professionperson.trim();
    }

    public String getProfessiondes() {
        return professiondes;
    }

    public void setProfessiondes(String professiondes) {
        this.professiondes = professiondes == null ? null : professiondes.trim();
    }

    public String getProfessionintrodue() {
        return professionintrodue;
    }

    public void setProfessionintrodue(String professionintrodue) {
        this.professionintrodue = professionintrodue == null ? null : professionintrodue.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}