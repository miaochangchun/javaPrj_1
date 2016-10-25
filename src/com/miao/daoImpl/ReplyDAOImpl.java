package com.miao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.miao.bean.Reply;
import com.miao.dao.ReplyDAO;
import com.miao.util.DBConnection;
import com.miao.util.Page;

public class ReplyDAOImpl implements ReplyDAO{

	@Override
	public void addReply(Reply reply) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String addSQL = "insert into tb_reply(replyContent, employeeId"
				+ ", replyTime, messageId) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(addSQL);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getEmployeeId());
			pstmt.setTimestamp(3, new Timestamp(reply.getReplyTime().getTime()));
			pstmt.setInt(4, reply.getMessageId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
	}

	@Override
	public List<Reply> findReplyByMsgId(int messageId, Page page) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select replyId, replyContent, employeeId, replyTime, messageId from tb_reply where messageId = ? limit ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<>();
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, messageId);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setReplyId(rs.getInt(1));
				reply.setReplyContent(rs.getString(2));
				reply.setEmployeeId(rs.getInt(3));
				reply.setReplyTime(rs.getTimestamp(4));
				reply.setMessageId(rs.getInt(5));
				list.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return list;
	}

	@Override
	public int findCountByMsgId(int messageId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String countSQL = "select count(*) from tb_reply where messageId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = connection.prepareStatement(countSQL);
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
