package com.ja.rubato.vo;

import java.util.Date;

public class CommentVo {
	private int c_no;
	private int b_no;
	private int m_no;
	private String c_content;
    private Date c_writedate;
    
    
    
	public CommentVo() {
		super();
	}



	public CommentVo(int c_no, int b_no, int m_no, String c_content, Date c_writedate) {
		super();
		this.c_no = c_no;
		this.b_no = b_no;
		this.m_no = m_no;
		this.c_content = c_content;
		this.c_writedate = c_writedate;
	}



	public int getC_no() {
		return c_no;
	}



	public void setC_no(int c_no) {
		this.c_no = c_no;
	}



	public int getB_no() {
		return b_no;
	}



	public void setB_no(int b_no) {
		this.b_no = b_no;
	}



	public int getM_no() {
		return m_no;
	}



	public void setM_no(int m_no) {
		this.m_no = m_no;
	}



	public String getC_content() {
		return c_content;
	}



	public void setC_content(String c_content) {
		this.c_content = c_content;
	}



	public Date getC_writedate() {
		return c_writedate;
	}



	public void setC_writedate(Date c_writedate) {
		this.c_writedate = c_writedate;
	}
	
}
