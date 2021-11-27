package com.atguigu.crud.bean;

public class BookInfo {
    private String bookid;

    private String bookname;

    private String booktype;

    private String booknumbers;

    private String borrowednumbers;

    private String remainingnumbers;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype == null ? null : booktype.trim();
    }

    public String getBooknumbers() {
        return booknumbers;
    }

    public void setBooknumbers(String booknumbers) {
        this.booknumbers = booknumbers == null ? null : booknumbers.trim();
    }

    public String getBorrowednumbers() {
        return borrowednumbers;
    }

    public void setBorrowednumbers(String borrowednumbers) {
        this.borrowednumbers = borrowednumbers == null ? null : borrowednumbers.trim();
    }

    public String getRemainingnumbers() {
        return remainingnumbers;
    }

    public void setRemainingnumbers(String remainingnumbers) {
        this.remainingnumbers = remainingnumbers == null ? null : remainingnumbers.trim();
    }

	public String getPwd() {
		// TODO Auto-generated method stub
		return null;
	}
}