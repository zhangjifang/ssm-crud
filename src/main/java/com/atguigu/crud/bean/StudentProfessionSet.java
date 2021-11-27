package com.atguigu.crud.bean;

public class StudentProfessionSet {
    private String studentid;

    private String professionid;
    public professioninfo professioninfo;
    public StudentInfo studentInfo;

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

	public String getPwd() {
		// TODO Auto-generated method stub
		return null;
	}
}