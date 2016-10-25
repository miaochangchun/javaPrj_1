package com.miao.dao;

import com.miao.bean.Criticism;

public interface CriticismDAO {
	/**
	 * �������
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism);
	/**
	 * ������ϢId��ѯ������Ϣ
	 * @param messageId
	 * @return
	 */
	public Criticism findCriticismByMsgId(int messageId);
}
