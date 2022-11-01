package com.concordia.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.concordia.connection.ConnectToApi;
import com.concordia.entity.Critic;
import com.concordia.entity.MultiMedia;
import com.concordia.repository.CriticRepository;

public class CriticsApiToDatabase {
	
	public static void convertAllMovieCriticDataToDatabase() {
		JSONObject responseData = ConnectToApi.getAllMovieCriticData();
		Critic criticData = new Critic();
		JSONArray results = (JSONArray) responseData.get("results");
		for(int i=0; i<results.size(); i++) {
			JSONObject data = (JSONObject) results.get(i);
			criticData = Critic.setAllCriticDataObject(data);
			CriticRepository.insertToCriticTable(criticData);
		}
	}
	
	public static void convertFullTimeMovieCriticDataToDatabase() {
		JSONObject responseData = ConnectToApi.getFullTimeMovieCriticData();
		Critic criticData = new Critic();
		JSONArray results = (JSONArray) responseData.get("results");
		for(int i=0; i<results.size(); i++) {
			JSONObject data = (JSONObject) results.get(i);
			criticData = Critic.setAllCriticDataObject(data);
			CriticRepository.insertToCriticTable(criticData);
		}
	}
	
	public static void convertPartTimeMovieCriticDataToDatabase() {
		JSONObject responseData = ConnectToApi.getPartTimeMovieCriticData();
		Critic criticData = new Critic();
		JSONArray results = (JSONArray) responseData.get("results");
		for(int i=0; i<results.size(); i++) {
			JSONObject data = (JSONObject) results.get(i);
			criticData = Critic.setAllCriticDataObject(data);
			CriticRepository.insertToCriticTable(criticData);
		}
	}
	
}
