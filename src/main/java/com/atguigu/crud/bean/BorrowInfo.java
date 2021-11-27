package com.atguigu.crud.bean;

public class BorrowInfo {
    private String borrowid;

    private String studentid;

    private String bookid;

    private String time;

    private String returntime;

    private String deadline;

    private String ifovertime;
    
public Partner Partner;
    
    public BookInfo BookInfo;

    public String getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(String borrowid) {
        this.borrowid = borrowid == null ? null : borrowid.trim();
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime == null ? null : returntime.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    public String getIfovertime() {
        return ifovertime;
    }

    public void setIfovertime(String ifovertime) {
        this.ifovertime = ifovertime == null ? null : ifovertime.trim();
    }

	public String getPwd() {
		// TODO Auto-generated method stub
		return null;
	}
}