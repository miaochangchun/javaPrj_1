package com.miao.bean;

import java.util.Date;

/**
 * 消息信息类
 * @author 10048
 *
 */
public class Message {
	private int messageId;			//消息id
	private String messageTitle;	//消息标题
	private String messageContent;	//消息内容
	private int employeeId;			//发布人id
	private Date publishTime;		//发布时间
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publicTime) {
		this.publishTime = publicTime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "messageId = " + this.getMessageId() + "\t" 
				+ "messageTitle = " + this.getMessageTitle() + "\t"
				+ "messageContent = " + this.getMessageContent() + "\t"
				+ "employeeId = " + this.getEmployeeId() + "\t" 
				+ "publishTime = " + this.getPublishTime();
	}
}
