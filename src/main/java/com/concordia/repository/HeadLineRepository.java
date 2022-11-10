package com.concordia.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.HeadLine;

public class HeadLineRepository {
	public static int insertToHeadLineTable(HeadLine headline) {
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		String sql = "Insert into headline(main,kicker,content_kicker,print_headline,seo,sub) values(?,?,?,?,?,?)";
		String sqlmulti = "Select headLineId from headline WHERE main=? AND kicker=?";
		
		int number = -1;
		PreparedStatement ps;
		try{
			ps = con.prepareStatement(sql);
			if(headline!=null && headline.getMain()!=null) {
				ps.setString(1, headline.getMain());
			}else {
				ps.setString(1, null);
			}
			if(headline!=null && headline.getKicker()!=null) {
				ps.setString(2, headline.getKicker());
			}else {
				ps.setString(2, null);
			}
			if(headline!=null && headline.getContent_kicker()!=null) {
				ps.setString(3, headline.getContent_kicker());
			}else {
				ps.setString(3, null);
			}
			if(headline!=null && headline.getPrint_headline()!=null) {
				ps.setString(4, headline.getPrint_headline());
			}else {
				ps.setString(4, null);
			}
			if(headline!=null && headline.getSeo()!=null) {
				ps.setString(5, headline.getSeo());
			}else {
				ps.setString(5, null);
			}
			if(headline!=null && headline.getSub()!=null) {
				ps.setString(6, headline.getSub());
			}else {
				ps.setString(6, null);
			}
		
			ps.executeUpdate();
			
			
			ps = con.prepareStatement(sqlmulti);
			
			if(headline!=null && headline.getMain() != null)
				ps.setString(1, headline.getMain());
			else
				ps.setString(1, null);
			if(headline!=null && headline.getKicker() != null)
				ps.setString(2, headline.getKicker());
			else
				ps.setString(2, null);
			
			ResultSet val = ps.executeQuery();
			if(val.next())
				number = val.getInt("headLineId");
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