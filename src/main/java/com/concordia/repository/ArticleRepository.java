package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.concordia.connection.ConnectToSql;
import com.concordia.entity.Article;
import com.concordia.entity.Media;
import com.concordia.entity.Keyword;
import com.concordia.entity.HeadLine;
import com.concordia.entity.ByLine;
public class ArticleRepository {
	public static boolean insertToArticleTable(Article articleData)
	{
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		Media media = articleData.getMedia();
		Keyword keyword = articleData.getKeyword();
		HeadLine headline = articleData.getHeadLine();
		ByLine byline = articleData.getByLine();
		
		int mediaId =MediaRepository.insertToMediaTable(media);
		int keywordId = KeywordRepository.insertToKeywordTable(keyword);
		int headlineId = HeadLineRepository.insertToHeadLineTable(headline);
		int byLineId = ByLineRepository.insertToByLineTable(byline);
		
		
		boolean status = false;
		String sql = "Insert into article(abstract, web_url,snippet,source,mediaId,headlineId,keywordId,pub_date,document_type,news_desk,section_name,bylineId,type_of_material,_id,word_count,uri) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, articleData.getAbstracts());
			ps.setString(2, articleData.getWeb_url());
			ps.setString(3, articleData.getSnippet());
			ps.setString(4, articleData.getSource());
			ps.setInt(5, mediaId);
			ps.setString(6, articleData.getPub_date());
			ps.setString(7, articleData.getDocument_type());
			ps.setString(8, articleData.getDocument_type());
			ps.setString(9, articleData.getNews_desk());
			ps.setString(10, articleData.getSection_name());
			//ps.setString(11, articleData.getSubsection_name());
			ps.setString(11, articleData.getType_of_material());
			ps.setString(12, articleData.get_id());
			ps.setString(13, articleData.getWord_count());
			ps.setString(14, articleData.getUri());
			ps.setInt(15, headlineId);
			ps.setInt(16, keywordId);
			ps.setInt(17, byLineId);
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