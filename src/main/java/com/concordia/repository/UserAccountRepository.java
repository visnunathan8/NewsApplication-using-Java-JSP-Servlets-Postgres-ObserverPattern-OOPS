package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.UserAccount;

public class UserAccountRepository {
	
	public String getUserId(UserAccount useraccount)
	{
		String id = "";
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		 
		String sql = "select userid from UserAccount where username = ? and password = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, useraccount.getUsername());
			ps.setString(2, useraccount.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) { 
				id = rs.getString("userid");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return id;
	}
	
	public boolean validate(UserAccount useraccount)
	{
		boolean status = false;
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		String sql = "select * from UserAccount where username = ? and password = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, useraccount.getUsername());
			ps.setString(2, useraccount.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return status;
	}
	
	public boolean insertToDatabase(UserAccount useraccount)
	{
		boolean status = false;
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();

		
		String sql = "Insert into UserAccount(username, password, userEmail, userMobile, userType) values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, useraccount.getUsername());
			ps.setString(2, useraccount.getPassword());
			ps.setString(3, useraccount.getUserEmail());
			ps.setString(4, useraccount.getUserMobile());
			if(useraccount.getUsername().startsWith("reviewer")) {
				ps.setString(5, "A");
			}else { 
				ps.setString(5, "U");
			}
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
	
	public static ArrayList<UserAccount> getPublishers()
	{
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		ArrayList<UserAccount> publisherIds = new ArrayList<UserAccount>();
		String sql = "select * from UserAccount where userType = 'A'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserAccount user = new UserAccount();
				user.setUserId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUserEmail(rs.getString("userEmail"));
				publisherIds.add(user);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return publisherIds;
	}
	
}
