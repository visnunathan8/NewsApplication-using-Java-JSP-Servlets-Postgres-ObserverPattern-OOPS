package com.concordia.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToSql {
	private static String dbUrl = "jdbc:mysql://localhost:3306/NewsAppDB?useSSL=false";
	private static String dbUname = "root";
	private static String dbPassword = "root@123";
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public static void loadDriver()
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
