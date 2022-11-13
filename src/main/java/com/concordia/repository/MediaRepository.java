package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.Media;

public class MediaRepository {
	public static int insertToMediaTable(Media media) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		String sql = "Insert into media(rank,type,subtype,width,height, caption, url,crop_name) values(?,?,?,?,?,?,?,?)";
		String sqlmulti = "Select MediaId from media WHERE rank=? AND type=?";

		PreparedStatement ps;
		int number = -1;
		try {
			ps = con.prepareStatement(sql);
			
			if(media!=null) {
				
				ps.setInt(1, media.getRank());
			
				if(media!=null && media.getSubType() != null) {
					ps.setString(2, media.getSubType());
				}else {
					ps.setString(2, null);
				}
				
				if(media!=null && media.getCaption() != null) {
					ps.setString(3, media.getCaption());
				}
				else {
					ps.setString(3, null);
				}
				
				if(media!=null && media.getUrl() != null) {
					ps.setString(4, media.getUrl());
				}else {
					ps.setString(4, null);
				}
				
				if(media!=null && media.getCrop_name() != null) {
					ps.setString(5, media.getCrop_name());
				}else {
					ps.setString(5, null);
				}
				
				ps.setInt(6, media.getWidth());
				
				if(media!=null) {
					ps.setInt(7, media.getHeight());
				}else {
					ps.setInt(7, -1);
				}
				
				if(media!=null && media.getType() != null) {
					ps.setString(8, media.getType());
				}
				else {
					ps.setString(8, null);
				}
				
				ps.executeUpdate();
				
				
				ps = con.prepareStatement(sqlmulti);
				if(media!=null) {
					ps.setInt(1, media.getRank());
				}else {
					ps.setInt(1, -1);
				}
				
				if(media!=null && media.getType() != null) {
					ps.setString(2, media.getType());
				}else {
					ps.setString(2, null);
				}
				
				ResultSet val = ps.executeQuery();
				
				if(val.next()) {
					number = val.getInt("mediaId");
				}
			}
		}
		catch (SQLException e) {
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
	return number;
}
}