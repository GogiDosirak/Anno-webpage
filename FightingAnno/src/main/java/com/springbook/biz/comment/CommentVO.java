package com.springbook.biz.comment;

import java.sql.Date;

public class CommentVO {
	private int seq;
	private int co_Seq;
	private String co_NickName;
	private String co_Content;
	private Date co_RegDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCo_NickName() {
		return co_NickName;
	}
	public void setCo_NickName(String co_NickName) {
		this.co_NickName = co_NickName;
	}
	public String getCo_Content() {
		return co_Content;
	}
	public void setCo_Content(String co_Content) {
		this.co_Content = co_Content;
	}
	public Date getCo_RegDate() {
		return co_RegDate;
	}
	public void setCo_RegDate(Date co_RegDate) {
		this.co_RegDate = co_RegDate;
	}
	public int getCo_Seq() {
		return co_Seq;
	}
	public void setCo_Seq(int co_Seq) {
		this.co_Seq = co_Seq;
	}
	
	
	
	

}
