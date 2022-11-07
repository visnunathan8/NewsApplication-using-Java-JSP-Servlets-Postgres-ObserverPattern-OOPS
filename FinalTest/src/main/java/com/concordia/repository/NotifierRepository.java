package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.concordia.connection.ConnectToSql;

public class NotifierRepository {
	
	public static ArrayList<Integer> getSubscriberIds(Integer publisherId) {
			
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		ArrayList<Integer> userAccountIds = new ArrayList<Integer>();
		
		String sql = "select * from Notifier where publisherId = "+publisherId;
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(sql);
			ResultSet val = ps.executeQuery();
			
			while(val.next()) {
				userAccountIds.add(val.getInt("subscriberId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return userAccountIds;
	}
	public static ArrayList<Integer> getPublisherIds(Integer subscriberId) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		ArrayList<Integer> userAccountIds = new ArrayList<Integer>();
		String sql = "select * from Notifier where subscriberId = "+subscriberId;
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ResultSet val = ps.executeQuery();
			
			while(val.next()) {
				userAccountIds.add(val.getInt("publisherId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return userAccountIds;
	}
	public static void insertSubscriberData(Integer subscriberId, Integer publisherId) {
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		int rowCount = 0;
		try {
			PreparedStatement  ps = null;
			String delSql = "delete from Notifier";
			ps = con.prepareStatement(delSql);
			int n = ps.executeUpdate();
			
			String sql = "Insert into Notifier(publisherId, subscriberId) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, publisherId);
			ps.setInt(2, subscriberId);
			rowCount = ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
	}
	public static void deleteSubscriberData(Integer publisherId, Integer subscriberId) {
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		try {
			String sql = "delete from Notifier where publisherId ="+publisherId;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeQuery();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
	}
}
