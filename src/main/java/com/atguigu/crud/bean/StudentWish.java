package com.atguigu.crud.bean;

import java.util.List;

public class StudentWish {
    private String studentid;

    private String professionid1;

    private String professionid2;

    private String professionid3;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getProfessionid1() {
        return professionid1;
    }

    public void setProfessionid1(String professionid1) {
        this.professionid1 = professionid1 == null ? null : professionid1.trim();
    }

    public String getProfessionid2() {
        return professionid2;
    }

    public void setProfessionid2(String professionid2) {
        this.professionid2 = professionid2 == null ? null : professionid2.trim();
    }

    public String getProfessionid3() {
        return professionid3;
    }

    public void setProfessionid3(String professionid3) {
        this.professionid3 = professionid3 == null ? null : professionid3.trim();
    }

	public List<StudentWish> getProfession() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPwd() {
		// TODO Auto-generated method stub
		return null;
	}
}