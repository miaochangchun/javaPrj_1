package com.miao.bean;

import java.util.Date;

/**
 * 员工信息类
 * @author 10048
 */
public class Employee {
	private int employeeId;			//员工编码
	private String employeeName;	//员工姓名
	private boolean employeeSex;	//员工性别
	private Date employeeBirth;		//出生日期
	private String employeePhone;	//办公室电话
	private String employeePlace;	//住址
	private Date joinTime;			//录入时间
	private String password;		//系统口令
	private boolean isLead;			//是否为管理层领导
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
