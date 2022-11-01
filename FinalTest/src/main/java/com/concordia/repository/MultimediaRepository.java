package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.MultiMedia;

public class MultimediaRepository {

	public static int insertToMultimediaTable(MultiMedia multimedia) {
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		String sql = "Insert into multimedia(type, src, width, height, credit) values(?,?,?,?,?)";
		String sqlmulti = "Select MultimediaId from multimedia WHERE type=? AND src=?";
		
		PreparedStatement ps;
		int number = -1;
		try {
			ps = con.prepareStatement(sql);
			if(multimedia!=null && multimedia.getType() != null) {
				ps.setString(1, multimedia.getType());
			
				if(multimedia!=null && multimedia.getSrc() != null)
					ps.setString(2, multimedia.getSrc());
				else
					ps.setString(2, null);
				if(multimedia!=null)
					ps.setInt(3, multimedia.getWidth());
				else
					ps.setInt(3, -1);
				if(multimedia!=null)
					ps.setInt(4, multimedia.getHeight());
				else
					ps.setInt(4, -1);
				if(multimedia!=null && multimedia.getCredit() != null)
					ps.setString(5, multimedia.getCredit());
				else
					ps.setString(5, null);
				ps.executeUpdate();
				
				
				ps = con.prepareStatement(sqlmulti);
				if(multimedia!=null && multimedia.getType() != null)
					ps.setString(1, multimedia.getType());
				else 
					ps.setString(1, null);
				if(multimedia!=null && multimedia.getSrc() != null)
					ps.setString(2, multimedia.getSrc());
				else
					ps.setString(2, null);
				ResultSet val = ps.executeQuery();
				if(val.next())
					number = val.getInt("MultimediaId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

}
