package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.MovieLink;
import com.concordia.entity.MultiMedia;
import com.concordia.entity.Review;

public class ReviewRepository {
	public static boolean insertToReviewTable(Review reviewData)
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		MultiMedia multimedia = reviewData.getMultimedia();
		MovieLink movieLink = reviewData.getMovielink();
		
		
		int multimediaId = MultimediaRepository.insertToMultimediaTable(multimedia);
		
		int movieLinkId = MovieLinkRepository.insertToMovieLinkTable(movieLink);
		boolean status = false;
		
		String sql = "Insert into review(display_title, mpaa_rating, critics_pick, byline, headline, summary_short, publication_date, opening_date, date_updated, movielinkId, multimediaId) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reviewData.getDisplay_title());
			ps.setString(2, reviewData.getMpaa_rating());
			ps.setInt(3, reviewData.getCritics_pick());
			ps.setString(4, reviewData.getByline());
			ps.setString(5, reviewData.getHeadline());
			ps.setString(6, reviewData.getSummary_short());
			ps.setString(7, reviewData.getPublication_date());
			ps.setString(8, reviewData.getOpening_date());
			ps.setString(9, reviewData.getDate_updated());
			ps.setInt(10, multimediaId);
			ps.setInt(11, movieLinkId);
			int rowCount = ps.executeUpdate();
			if(rowCount > 0) {
				status = true;
			}else {
				status = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
