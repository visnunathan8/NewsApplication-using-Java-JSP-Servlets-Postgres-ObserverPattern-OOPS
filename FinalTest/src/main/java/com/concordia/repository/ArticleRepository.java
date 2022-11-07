package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.Article;
import com.concordia.entity.Media;

public class ArticleRepository {
	public static boolean insertToArticleTable(Article articleData)
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		Media media = articleData.getMedia();
		int multimediaId = MultimediaRepository.insertToMultimediaTable(multimedia);
		boolean status = false;
		String sql = "Insert into critic(display_name, sort_name, status, bio, multimediaId) values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, articleData.getDisplay_name());
			ps.setString(2, articleData.getSort_name());
			ps.setString(3, articleData.getStatus());
			ps.setString(4, articleData.getBio());
			ps.setInt(5, multimediaId);
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
