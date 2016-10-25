package com.miao.factory;

import com.miao.dao.EmployeeDAO;
import com.miao.daoImpl.EmployeeDAOImpl;

public class EmployeDAOFactory {
	/**
	 * 返回DAO实现类的对象
	 * @return
	 */
	public static EmployeeDAO getEmployeeDAOInstance(){
		return new EmployeeDAOImpl();
	}
}
