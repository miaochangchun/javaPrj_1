package com.miao.bean;

import java.util.Date;

/**
 * 回复信息类
 * @author 10048
 *
 */
public class Reply {
	private int replyId;		//回复Id
	private String replyContent;//回复内容
	private int employeeId;		//回复人Id
	private Date replyTime;		//回复时间
	private int messageId;		//消息Id
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "employeeId = " + this.getEmployeeId() + "\t"
				+ "messageId = " + this.getMessageId() + "\t"
				+ "replyContent = " + this.getReplyContent() + "\t"
				+ "repleyId = " + this.getReplyId() + "\t" 
				+ "repleyTime + " + this.getReplyTime();
	}
}
