package com.newsapp.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newsapp.entity.UserAccount;

public class UserAccountRepository {
	private String dbUrl = "jdbc:mysql://localhost:3306/DietApplication";
	private String dbUname = "root";
	private String dbPassword = "root@123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver()
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Cannot connect to database", e);
		}
		return con;
	}
	
	public boolean validate(UserAccount useraccount)
	{
		boolean status = false;
		
		loadDriver();
		Connection con = getConnection();
		
		String sql = "select * from UserAccount where username = ? and password =?";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, useraccount.getUsername());
		ps.setString(2, useraccount.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		System.out.println("ASDf"+status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
