package com.miao.factory;

import com.miao.dao.EmployeeDAO;
import com.miao.daoImpl.EmployeeDAOImpl;

public class EmployeDAOFactory {
	/**
	 * ����DAOʵ����Ķ���
	 * @return
	 */
	public static EmployeeDAO getEmployeeDAOInstance(){
		return new EmployeeDAOImpl();
	}
}
