package com.mytest.board.project.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("projectVO")
public class ProjectVO {
	private int level;
	private int articleNO;
	private int parentNO;
	private String content;
	private String writer;
	private Date writeDate;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getArticleNO() {
		return articleNO;
	}
	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}
	public int getParentNO() {
		return parentNO;
	}
	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
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
		return "ProjectVO [level=" + level + ", articleNO=" + articleNO + ", parentNO=" + parentNO + ", content="
				+ content + ", writer=" + writer + ", writeDate=" + writeDate + "]";
	}
}
