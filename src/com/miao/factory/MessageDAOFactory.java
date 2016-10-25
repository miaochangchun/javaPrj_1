package com.miao.factory;

import com.miao.dao.MessageDAO;
import com.miao.daoImpl.MessageDAOImpl;

public class MessageDAOFactory {
	public static MessageDAO getMessageDAOInstance(){
		return new MessageDAOImpl();
	}
}
