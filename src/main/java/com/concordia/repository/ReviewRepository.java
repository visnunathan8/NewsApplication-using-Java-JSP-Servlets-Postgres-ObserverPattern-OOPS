package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.concordia.connection.ConnectToSql;
import com.concordia.entity.MovieLink;
import com.concordia.entity.MultiMedia;
import com.concordia.entity.Review;

public class ReviewRepository {
	public static Integer insertToReviewTable(Review reviewData)
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		MultiMedia multimedia = reviewData.getMultimedia();
		MovieLink movieLink = reviewData.getMovielink();
		
		int multimediaId = -1;
		if(multimedia != null) {
			multimediaId = MultimediaRepository.insertToMultimediaTable(multimedia);
		}
		int movieLinkId = -1;
		if(movieLink != null) {
			movieLinkId = MovieLinkRepository.insertToMovieLinkTable(movieLink);
		}
		
		String sql = "Insert into review(display_title, mpaa_rating, critics_pick, byline, headline, summary_short, publication_date, opening_date, date_updated, movielinkId, multimediaId) values(?,?,?,?,?,?,?,?,?,?,?)";
		String sqlmulti = "Select ReviewId from review WHERE display_title = '"+reviewData.getDisplay_title().replaceAll("'", "")+"'";
		PreparedStatement ps;
		Integer number = -1;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reviewData.getDisplay_title().replaceAll("'", ""));
			ps.setString(2, reviewData.getMpaa_rating());
			ps.setInt(3, reviewData.getCritics_pick());
			ps.setString(4, reviewData.getByline());
			ps.setString(5, reviewData.getHeadline());
			ps.setString(6, reviewData.getSummary_short());
			ps.setString(7, reviewData.getPublication_date());
			ps.setString(8, reviewData.getOpening_date());
			ps.setString(9, reviewData.getDate_updated());
			ps.setInt(10, movieLinkId);
			ps.setInt(11, multimediaId);
			int rowCount = ps.executeUpdate();
			
			 int n = ps.executeUpdate();
			 ps = con.prepareStatement(sqlmulti);
			 ResultSet val = ps.executeQuery();
			if(val.next())
				number = val.getInt("ReviewId");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return number;
	}
	
	public static ArrayList<Review> selectFromReviewTable()
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		ArrayList<Review> reviewDatas = new ArrayList<Review>();
				
		String sql = "select * from review";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet val = ps.executeQuery();
			
			while(val.next()) {
				Review reviewData = new Review();
				reviewData.setDisplay_title(val.getString("display_title"));
				reviewData.setMpaa_rating(val.getString("mpaa_rating"));
				reviewData.setCritics_pick(val.getInt("critics_pick"));
				reviewData.setByline(val.getString("byline"));
				reviewData.setHeadline(val.getString("headline"));
				reviewData.setSummary_short(val.getString("summary_short"));
				reviewData.setOpening_date(val.getString("opening_date"));
				reviewData.setDate_updated(val.getString("date_updated"));
				reviewData.setMovielink(MovieLinkRepository.selectFromMovieLink(val.getInt("movielinkid")));
				reviewData.setMultimedia(MultimediaRepository.selectFromMultimedia(val.getInt("MultimediaId")));
				reviewDatas.add(reviewData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return reviewDatas;
	}
	public static Review selectAReview(Integer reviewId)
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		Review reviewData = new Review();
				
		String sql = "select * from review where ReviewId="+reviewId;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet val = ps.executeQuery();
			while(val.next()) {
				reviewData.setDisplay_title(val.getString("display_title"));
				reviewData.setMpaa_rating(val.getString("mpaa_rating"));
				reviewData.setCritics_pick(val.getInt("critics_pick"));
				reviewData.setByline(val.getString("byline"));
				reviewData.setHeadline(val.getString("headline"));
				reviewData.setSummary_short(val.getString("summary_short"));
				reviewData.setOpening_date(val.getString("opening_date"));
				reviewData.setDate_updated(val.getString("date_updated"));
				reviewData.setPublication_date(val.getString("publication_date"));
				reviewData.setMovielink(MovieLinkRepository.selectFromMovieLink(val.getInt("movielinkid")));
				reviewData.setMultimedia(MultimediaRepository.selectFromMultimedia(val.getInt("MultimediaId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { con.close(); } 
				catch (SQLException ignore) {}
		}
		return reviewData;
	}
}
