package com.concordia.entity;

import org.json.simple.JSONObject;

public class Keyword {
	int keywordId;
	String name;
	String  value;
	int rank;
	String major;
	
	public int getKeywordId() {
		return keywordId;
	}
	public void setKeywordId(int keywordId) {
		keywordId = keywordId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMajor() {
		return value;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public static Keyword setKeywordData(JSONObject keywordData) {
		Keyword keyword = new Keyword();
		if(keywordData != null) {
			if(keywordData.get("rank")!=null && !(keywordData.get("rank").toString().isEmpty()))
				keyword.setRank( ((Long) keywordData.get("rank")).intValue());
			if(keywordData.get("name")!=null && !(keywordData.get("name").toString().isEmpty()))
				keyword.setName( ( keywordData.get("name")).toString());
			if(keywordData.get("value")!=null && !(keywordData.get("value").toString().isEmpty()))
				keyword.setValue( ( keywordData.get("value")).toString());
			if(keywordData.get("major")!=null && !(keywordData.get("major").toString().isEmpty()))
				keyword.setMajor( ( keywordData.get("major")).toString());
			
		}
	
		return keyword;
	}
	
}
