package com.miao.dao;

import java.util.List;

import com.miao.bean.Reply;
import com.miao.util.Page;

public interface ReplyDAO {
	/**
	 * 添加回复信息
	 * @param reply
	 */
	public void addReply(Reply reply);
	/**
	 * 查询消息的回复记录，并分页显示查询
	 * @param messageId
	 * @param page
	 * @return
	 */
	public List<Reply> findReplyByMsgId(int messageId, Page page);
	/**
	 * 查询消息的回复记录数
	 * @param messageId	消息Id
	 * @return
	 */
	public int findCountByMsgId(int messageId);
}
