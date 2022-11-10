package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.Keyword;

public class KeywordRepository {
	public static int insertToKeywordTable(Keyword keyword) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		int number = -1;
		
		String sql = "Insert into keyword(name,value,rank,major) values(?,?,?,?)";
		String sqlmulti = "Select keywordId from keyword WHERE name=? AND rank=?";
		
		PreparedStatement ps;
		try{
			ps = con.prepareStatement(sql);
			if(keyword!=null && keyword.getName()!=null) {
				ps.setString(1, keyword.getName());
			}else {
				ps.setString(1, null);
			}
			if(keyword!=null && keyword.getValue()!=null) {
				ps.setString(2, keyword.getValue());
			}else {
				ps.setString(2, null);
			}
			if(keyword!=null && keyword.getMajor()!=null) {
				ps.setString(3, keyword.getMajor());
			}else {
				ps.setString(3, null);
			}
			if(keyword!=null) {
				ps.setInt(4, keyword.getRank());
			}else {
				ps.setInt(4, -1);
			}
			ps.executeUpdate();
			
			
			ps = con.prepareStatement(sqlmulti);
			if(keyword!=null)
				ps.setInt(1, keyword.getRank());
			else 
				ps.setInt(1, -1);
			
			if(keyword!=null && keyword.getName() != null)
				ps.setString(2, keyword.getName());
			else
				ps.setString(2, null);
			
			ResultSet val = ps.executeQuery();
			if(val.next())
				number = val.getInt("keywordId");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		
		return number;
	}

}