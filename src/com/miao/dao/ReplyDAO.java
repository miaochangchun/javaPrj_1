package com.miao.dao;

import java.util.List;

import com.miao.bean.Reply;
import com.miao.util.Page;

public interface ReplyDAO {
	/**
	 * ��ӻظ���Ϣ
	 * @param reply
	 */
	public void addReply(Reply reply);
	/**
	 * ��ѯ��Ϣ�Ļظ���¼������ҳ��ʾ��ѯ
	 * @param messageId
	 * @param page
	 * @return
	 */
	public List<Reply> findReplyByMsgId(int messageId, Page page);
	/**
	 * ��ѯ��Ϣ�Ļظ���¼��
	 * @param messageId	��ϢId
	 * @return
	 */
	public int findCountByMsgId(int messageId);
}
