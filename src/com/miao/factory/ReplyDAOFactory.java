package com.miao.factory;

import com.miao.dao.ReplyDAO;
import com.miao.daoImpl.ReplyDAOImpl;

public class ReplyDAOFactory {
	public static ReplyDAO getReplyDAOInstance(){
		return new ReplyDAOImpl();
	}
}
