package com.miao.bean;

import java.util.Date;

/**
 * 批复消息类
 * @author 10048
 *
 */
public class Criticism {
	private int criticismId;			//批复Id
	private String criticismContent;	//批复内容
	private int employeeId;				//皮肤人Id
	private Date criticismTime;			//批复时间
	private int messageId;				//消息Id
	public int getCriticismId() {
		return criticismId;
	}
	public void setCriticismId(int criticismId) {
		this.criticismId = criticismId;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
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
		return "criticismContent = " + this.getCriticismContent() + "\t"
				+ "criticismId = " + this.getCriticismId() + "\t"
				+ "criticismTime = " + this.getCriticismTime() + "\t"
				+ "employeeId = " + this.getEmployeeId() + "\t"
				+ "messageId = " + this.getMessageId();
	}
}
