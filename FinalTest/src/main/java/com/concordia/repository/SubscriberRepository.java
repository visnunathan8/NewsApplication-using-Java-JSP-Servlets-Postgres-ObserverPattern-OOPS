package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.concordia.connection.ConnectToSql;

public class SubscriberRepository {
	public static Integer insertSubscriberData(ArrayList<Integer> subscriberIds, Integer reviewId) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		int rowCount = 0;
		try {
			for(int i=0; i<subscriberIds.size(); i++) {
				String sql = "Insert into subscribedData(ReviewId, subscriberId) values(?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(0, subscriberIds.get(i));
				ps.setInt(1, reviewId);
				rowCount = ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return rowCount;
	}
}
