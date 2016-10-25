package com.miao.factory;

import com.miao.dao.CriticismDAO;
import com.miao.daoImpl.CriticismDAOImpl;

public class CriticismDAOFactory {
	/**
	 * 工厂方法对象
	 * @return	接口的实现对象
	 */
	public static CriticismDAO getCriticismDAOInstance(){
		return new CriticismDAOImpl();
	}
}
