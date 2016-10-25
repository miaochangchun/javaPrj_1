package com.miao.dao;

import java.util.List;

import com.miao.bean.Message;
import com.miao.util.Page;

public interface MessageDAO {
	/**
	 * 添加消息的方法
	 * @param message
	 */
	public void addMessage(Message message);
	/**
	 * 更新消息的方法
	 * @param message
	 */
	public void updateMessage(Message message);
	/**
	 * 删除消息的方法
	 * @param messageId
	 */
	public void deleteMessage(int messageId);
	/**
	 * 分页查询消息的方法
	 * @param page
	 * @return
	 */
	public List<Message> findAllMessage(Page page);
	/**
	 * 按照消息Id查询
	 * @param messageId
	 * @return
	 */
	public Message findMessageById(int messageId);
	/**
	 * 查询消息记录总数
	 * @return
	 */
	public int findAllCount();
}
