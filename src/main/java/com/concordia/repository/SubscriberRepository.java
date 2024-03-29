package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.concordia.connection.ConnectToSql;

public class SubscriberRepository {
	
	/**
	 * 
	 * @param publisherId
	 * @param reviewId
	 * @return int value representing the insertion value
	 */
	public static Integer insertSubscriberData(Integer publisherId, Integer reviewId) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		int rowCount = 0;
		try {
			
			String sql = "Insert into subscribedData(ReviewId, subscriberId) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reviewId);
			ps.setInt(2, publisherId);
			rowCount = ps.executeUpdate();
			
		} catch (SQLException e) {
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
		return rowCount;
	}
	
	/**
	 * 
	 * @param subscriberId
	 * @return list of reviewIds
	 */
	public static ArrayList<Integer> getReviewId(Integer subscriberId) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		ArrayList<Integer> reviewIds = new ArrayList<>();
		int reviewId = -1;
		
		try {
			String sql = "select ReviewId from subscribedData where subscriberId="+subscriberId;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reviewId = rs.getInt("ReviewId");
				reviewIds.add(reviewId);
			}
		} catch (SQLException e) {
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
		return reviewIds;
	}
}
