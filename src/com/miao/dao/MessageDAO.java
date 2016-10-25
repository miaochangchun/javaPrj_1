package com.miao.dao;

import java.util.List;

import com.miao.bean.Message;
import com.miao.util.Page;

public interface MessageDAO {
	/**
	 * �����Ϣ�ķ���
	 * @param message
	 */
	public void addMessage(Message message);
	/**
	 * ������Ϣ�ķ���
	 * @param message
	 */
	public void updateMessage(Message message);
	/**
	 * ɾ����Ϣ�ķ���
	 * @param messageId
	 */
	public void deleteMessage(int messageId);
	/**
	 * ��ҳ��ѯ��Ϣ�ķ���
	 * @param page
	 * @return
	 */
	public List<Message> findAllMessage(Page page);
	/**
	 * ������ϢId��ѯ
	 * @param messageId
	 * @return
	 */
	public Message findMessageById(int messageId);
	/**
	 * ��ѯ��Ϣ��¼����
	 * @return
	 */
	public int findAllCount();
}
