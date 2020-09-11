package com.mytest.board.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("commentVO")
public class CommentVO {
	private int coId;
	private int boId;
	private String content;
	private String writer;
	private Date writeDate;
	public int getCoId() {
		return coId;
	}
	public void setCoId(int coId) {
		this.coId = coId;
	}
	public int getBoId() {
		return boId;
	}
	public void setBoId(int boId) {
		this.boId = boId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "CommentVO [coId=" + coId + ", boId=" + boId + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + "]";
	}
}
