package com.miao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.miao.bean.Criticism;
import com.miao.dao.CriticismDAO;
import com.miao.util.DBConnection;

public class CriticismDAOImpl implements CriticismDAO{

	@Override
	public void addCriticism(Criticism criticism) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String addSQL = "insert into tb_criticism(criticismContent, criticismTime, employeeId, messageId) values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(addSQL);
			pstmt.setString(1, criticism.getCriticismContent());
			pstmt.setTimestamp(2, new Timestamp(criticism.getCriticismTime().getTime()));
			pstmt.setInt(3, criticism.getEmployeeId());
			pstmt.setInt(4, criticism.getMessageId());
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
	public Criticism findCriticismByMsgId(int messageId) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		String findSQL = "select criticismId, criticismContent, employeeId, criticismTime, messageId "
				+ " from tb_criticism where messageId = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Criticism criticism = null;
		try {
			pstmt = connection.prepareStatement(findSQL);
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				criticism = new Criticism();
				criticism.setCriticismId(rs.getInt(1));
				criticism.setCriticismContent(rs.getString(2));
				criticism.setEmployeeId(rs.getInt(3));
				criticism.setCriticismTime(rs.getTimestamp(4));
				criticism.setMessageId(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(connection);
		}
		return criticism;
	}

}
