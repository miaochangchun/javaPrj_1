package com.miao.bean;

import java.util.Date;

/**
 * �ظ���Ϣ��
 * @author 10048
 *
 */
public class Reply {
	private int replyId;		//�ظ�Id
	private String replyContent;//�ظ�����
	private int employeeId;		//�ظ���Id
	private Date replyTime;		//�ظ�ʱ��
	private int messageId;		//��ϢId
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
