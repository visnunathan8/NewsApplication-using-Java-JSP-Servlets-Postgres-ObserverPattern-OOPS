package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.Critic;
import com.concordia.entity.MultiMedia;

public class CriticRepository {

	public static boolean insertToCriticTable(Critic criticData)
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		MultiMedia multimedia = criticData.getMultimedia();
		int multimediaId = MultimediaRepository.insertToMultimediaTable(multimedia);
		boolean status = false;
		String sql = "Insert into critic(display_name, sort_name, status, bio, multimediaId) values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, criticData.getDisplay_name());
			ps.setString(2, criticData.getSort_name());
			ps.setString(3, criticData.getStatus());
			ps.setString(4, criticData.getBio());
			ps.setInt(5, multimediaId);
			int rowCount = ps.executeUpdate();
			if(rowCount > 0) {
				status = true;
			}else {
				status = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return status;
	}
}
