package com.concordia.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConnectToApi {
	/**
	 * 
	 * @param url
	 * @return JSON API data
	 */
	public static JSONObject getData(String url) {
		JSONObject myResponse = new JSONObject();
		try {
		    URL obj = new URL(url);
		    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		    con.setRequestMethod("GET");
		    con.setRequestProperty("User-Agent", "Mozilla/5.0");
		    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();
		    while ((inputLine = in.readLine()) != null) {
		    	response.append(inputLine);
		    }
		    in.close();
		    myResponse = (JSONObject) new JSONParser().parse(response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	    return myResponse;
	}
	
	/**
	 * 
	 * @return JSON API data for All Movie Critic Data
	 */
	public static JSONObject getAllMovieCriticData() {
		String url = "https://api.nytimes.com/svc/movies/v2/critics/all.json?api-key=WadOSxHKnxkdxCW0uz8oh0WJPZnoVHcp";
		return getData(url);
	}
	
	/**
	 * 
	 * @return JSON API data for Full Movie Critic Data
	 */
	public static JSONObject getFullTimeMovieCriticData() {
		String url = "https://api.nytimes.com/svc/movies/v2/critics/full-time.json?api-key=WadOSxHKnxkdxCW0uz8oh0WJPZnoVHcp";
		return getData(url);
	}
	
	/**
	 * 
	 * @return JSON API data for Part Movie Critic Data
	 */
	public static JSONObject getPartTimeMovieCriticData() {
		String url = "https://api.nytimes.com/svc/movies/v2/critics/part-time.json?api-key=WadOSxHKnxkdxCW0uz8oh0WJPZnoVHcp";
		return getData(url);
	}
	
	/**
	 * 
	 * @return JSON API data for All Movie Review Data
	 */
	public static JSONObject getAllMovieReviewsData() {
		String url = "https://api.nytimes.com/svc/movies/v2/reviews/all.json?api-key=WadOSxHKnxkdxCW0uz8oh0WJPZnoVHcp";
		return getData(url);
	}
	
	/**
	 * 
	 * @return JSON API data for Picks Movie Review Data
	 */
	public static JSONObject getPicksMovieReviewsData() {
		String url = "https://api.nytimes.com/svc/movies/v2/reviews/picks.json?api-key=WadOSxHKnxkdxCW0uz8oh0WJPZnoVHcp";
		return getData(url);
	}
	
	/**
	 * 
	 * @return JSON API data for All Article Data
	 */
	public static JSONObject getArticleData() {
		String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=WadOSxHKnxkdxCW0uz8oh0WJPZnoVHcp";
		return getData(url);
	}
}
