package com.miao.dao;

import java.util.List;

import com.miao.bean.Employee;

public interface EmployeeDAO {
	/**
	 * 往数据库中添加员工信息
	 * @param employee
	 */
	public void addEmployee(Employee employee);
	/**
	 * 更新员工信息
	 * @param employee
	 */
	public void updateEmployee(Employee employee);
	/**
	 * 根据employeId删除员工信息
	 * @param employeeId
	 */
	public void deleteEmployee(int employeeId);
	/**
	 * 查询所有员工信息的方法
	 * @return
	 */
	public List<Employee> findAllEmployee();
	/**
	 * 根据员工employeeId查询员工信息
	 * @param employeeId
	 * @return
	 */
	public Employee findEmployeeById(int employeeId);
}
