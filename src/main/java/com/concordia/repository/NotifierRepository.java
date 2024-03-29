package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.concordia.connection.ConnectToSql;

public class NotifierRepository {
	
	/**
	 * 
	 * @param publisherId
	 * @return List of subscriberIds
	 */
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
				try { 
					con.close(); 
				} 
				catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
		return userAccountIds;
	}
	
	/**
	 * 
	 * @param subscriberId
	 * @return List of publisherIds
	 */
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
				try { 
					con.close(); 
				} 
				catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
		return userAccountIds;
	}
	
	/**
	 * 
	 * @param subscriberId
	 * @param publisherId
	 */
	public static void insertSubscriberData(Integer subscriberId, Integer publisherId) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		try {
			PreparedStatement  ps = null;
			String sql = "Insert into Notifier(publisherId, subscriberId) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, publisherId);
			ps.setInt(2, subscriberId);
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { 
					con.close(); 
				} 
				catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
	}
	
	/**
	 * 
	 * @param publisherId
	 */
	public static void deleteSubscriberData(Integer publisherId) {
		
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
				try { 
					con.close(); 
				} 
				catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
	}
	
	/**
	 * 
	 * @param subscriberId
	 */
	public static void deletePublisherData(Integer subscriberId) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		try {
			String sql = "delete from Notifier where subscriberId ="+subscriberId;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { 
					con.close(); 
				} 
				catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
	}
}
