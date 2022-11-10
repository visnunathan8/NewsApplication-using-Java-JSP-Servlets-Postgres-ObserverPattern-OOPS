package com.concordia.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.concordia.connection.ConnectToSql;
import com.concordia.entity.ByLine;

public class ByLineRepository {
	public static int insertToByLineTable(ByLine byLine) {
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		int number = -1;
		String sql = "Insert into byline(original,organisation) values(?,?)";
		String sqlmulti = "Select bylineId from byline WHERE original=? AND organisation=?";

		PreparedStatement ps;
		try{
			ps = con.prepareStatement(sql);
			if(byLine!=null && byLine.getOriginal()!=null) {
				ps.setString(1, byLine.getOriginal());
			}else {
				ps.setString(1, null);
			}
			if(byLine!=null && byLine.getOrganisation()!=null) {
				ps.setString(2, byLine.getOrganisation());
			}else {
				ps.setString(2, null);
			}
			
			ps.executeUpdate();
			ps = con.prepareStatement(sqlmulti);
			if(byLine!=null && byLine.getOriginal() != null)
				ps.setString(2, byLine.getOriginal());
			else
				ps.setString(2, null);
			
			if(byLine!=null && byLine.getOrganisation() != null)
				ps.setString(2, byLine.getOrganisation());
			else
				ps.setString(2, null);
			
			ResultSet val = ps.executeQuery();
			if(val.next())
				number = val.getInt("bylineId");
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