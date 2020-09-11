package com.mytest.board.message.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("messageVO")
public class MessageVO {
	
	private int messageNO;
	private String sendId;
	private String toId;
	private String content;
	private Date writeDate;
	private int seAva;
	private int reAva;
	private int seRead;
	private int reRead;
	
	public int getMessageNO() {
		return messageNO;
	}
	public void setMessageNO(int messageNO) {
		this.messageNO = messageNO;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getSeAva() {
		return seAva;
	}
	public void setSeAva(int seAva) {
		this.seAva = seAva;
	}
	public int getReAva() {
		return reAva;
	}
	public void setReAva(int reAva) {
		this.reAva = reAva;
	}
	public int getSeRead() {
		return seRead;
	}
	public void setSeRead(int seRead) {
		this.seRead = seRead;
	}
	public int getReRead() {
		return reRead;
	}
	public void setReRead(int reRead) {
		this.reRead = reRead;
	}
	@Override
	public String toString() {
		return "MessageVO [messageNO=" + messageNO + ", sendId=" + sendId + ", toId=" + toId + ", content=" + content
				+ ", writeDate=" + writeDate + ", seAva=" + seAva + ", reAva=" + reAva + ", seRead=" + seRead
				+ ", reRead=" + reRead + "]";
	}
}
