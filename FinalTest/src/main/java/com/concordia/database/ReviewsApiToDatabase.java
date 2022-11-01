package com.concordia.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.concordia.connection.ConnectToApi;
import com.concordia.entity.Critic;
import com.concordia.entity.Review;
import com.concordia.repository.CriticRepository;
import com.concordia.repository.ReviewRepository;

public class ReviewsApiToDatabase {
	public static void convertAllMovieReviewsDataToDatabase() {
		JSONObject responseData = ConnectToApi.getAllMovieReviewsData();
		Review review = new Review();
		JSONArray results = (JSONArray) responseData.get("results");
		for(int i=0; i<results.size(); i++) {
			JSONObject data = (JSONObject) results.get(i);
			review = Review.setAllReviewDataObject(data);
			 ReviewRepository.insertToReviewTable(review);
		}
	}
	public static void convertPicksMovieReviewsDataToDatabase() {
		JSONObject responseData = ConnectToApi.getPicksMovieReviewsData();
		Review review = new Review();
		JSONArray results = (JSONArray) responseData.get("results");
		for(int i=0; i<results.size(); i++) {
			JSONObject data = (JSONObject) results.get(i);
			review = Review.setAllReviewDataObject(data);
			 ReviewRepository.insertToReviewTable(review);
		}
	}
	
}
