package com.miao.dao;

import java.util.List;

import com.miao.bean.Employee;

public interface EmployeeDAO {
	/**
	 * �����ݿ������Ա����Ϣ
	 * @param employee
	 */
	public void addEmployee(Employee employee);
	/**
	 * ����Ա����Ϣ
	 * @param employee
	 */
	public void updateEmployee(Employee employee);
	/**
	 * ����employeIdɾ��Ա����Ϣ
	 * @param employeeId
	 */
	public void deleteEmployee(int employeeId);
	/**
	 * ��ѯ����Ա����Ϣ�ķ���
	 * @return
	 */
	public List<Employee> findAllEmployee();
	/**
	 * ����Ա��employeeId��ѯԱ����Ϣ
	 * @param employeeId
	 * @return
	 */
	public Employee findEmployeeById(int employeeId);
}
