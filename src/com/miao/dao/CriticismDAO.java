package com.miao.dao;

import com.miao.bean.Criticism;

public interface CriticismDAO {
	/**
	 * 添加批复
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism);
	/**
	 * 根据消息Id查询批复信息
	 * @param messageId
	 * @return
	 */
	public Criticism findCriticismByMsgId(int messageId);
}
