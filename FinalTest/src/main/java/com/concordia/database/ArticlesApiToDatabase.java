package com.concordia.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.concordia.connection.ConnectToApi;
import com.concordia.entity.Article;
import com.concordia.repository.ArticleRepository;

public class ArticlesApiToDatabase {
	
	public static void convertAllArticleDataToDatabase() {
		JSONObject responseData = ConnectToApi.getArticleData();
		Article articleData = new Article();
		JSONArray results = (JSONArray) responseData.get("docs");
		for(int i=0; i<results.size(); i++) {
			JSONObject data = (JSONObject) results.get(i);
			articleData = Article.setAllArticleDataObject(data);
			ArticleRepository.insertToArticleTable(articleData);
		}
	}
}
