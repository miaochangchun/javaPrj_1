package com.miao.factory;

import com.miao.dao.CriticismDAO;
import com.miao.daoImpl.CriticismDAOImpl;

public class CriticismDAOFactory {
	/**
	 * ������������
	 * @return	�ӿڵ�ʵ�ֶ���
	 */
	public static CriticismDAO getCriticismDAOInstance(){
		return new CriticismDAOImpl();
	}
}
