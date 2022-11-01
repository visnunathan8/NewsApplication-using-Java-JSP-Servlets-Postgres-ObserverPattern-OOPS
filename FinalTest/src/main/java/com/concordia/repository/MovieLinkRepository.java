package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.MovieLink;

public class MovieLinkRepository {
	public static int insertToMovieLinkTable(MovieLink movielink)
	{
		if(movielink == null) return -1;
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		boolean status = false;
		int number = -1;
		String sql = "Insert into movielink(type, url, suggested_link_text) values(?,?,?)";
		String sqlmulti = "Select Linkid from movielink WHERE type=? AND url=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, movielink.getType());
			ps.setString(2, movielink.getURL());
			ps.setString(3, movielink.getSuggested_link_text());
			ps.executeUpdate();
			
			ps = con.prepareStatement(sqlmulti);
			if(movielink!=null && movielink.getType() != null)
				ps.setString(1, movielink.getType());
			else 
				ps.setString(1, null);
			if(movielink!=null && movielink.getURL() != null)
				ps.setString(2, movielink.getURL());
			else
				ps.setString(2, null);
			ResultSet val = ps.executeQuery();
			if(val.next())
				number = val.getInt("Linkid");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
}
