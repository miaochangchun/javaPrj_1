package com.miao.bean;

import java.util.Date;

/**
 * Ա����Ϣ��
 * @author 10048
 */
public class Employee {
	private int employeeId;			//Ա������
	private String employeeName;	//Ա������
	private boolean employeeSex;	//Ա���Ա�
	private Date employeeBirth;		//��������
	private String employeePhone;	//�칫�ҵ绰
	private String employeePlace;	//סַ
	private Date joinTime;			//¼��ʱ��
	private String password;		//ϵͳ����
	private boolean isLead;			//�Ƿ�Ϊ������쵼
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean isEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(Date employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePlace() {
		return employeePlace;
	}
	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLead() {
		return isLead;
	}
	public void setLead(boolean isLead) {
		this.isLead = isLead;
	}
	public String toString(){
		return "employeeId = " + this.getEmployeeId() + "\t" 
				+ "employeeName = " + this.getEmployeeName() + "\t"
				+ "employeeSex = " + this.isEmployeeSex() + "\t"
				+ "employeeBirth = " + this.getEmployeeBirth() + "\t"
				+ "employeePhone = " + this.getEmployeePhone() + "\t"
				+ "employeePlace = " + this.getEmployeePlace() + "\t"
				+ "employeeJointime = " + this.getJoinTime() + "\t"
				+ "employeePassword = " + this.getPassword() + "\t"
				+ "employeeisLead = " + this.isLead();
	}
}
