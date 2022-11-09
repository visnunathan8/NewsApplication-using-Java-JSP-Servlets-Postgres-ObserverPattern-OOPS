package com.concordia.entity;

import org.json.simple.JSONObject;

public class HeadLine {
	int headLineId;
	String main;
	String kicker;
	String content_kicker;
	String print_headline;
	String seo;
	String sub;
	

	public int getHeadLineid() {
		return headLineId;
	}
	public void setLinkid(int linkid) {
		headLineId = headLineId;
	}
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getKicker() {
		return kicker;
	}
	public void setKicker(String kicker) {
		this.kicker = kicker;
	}
	public String getContent_kicker() {
		return content_kicker;
	}
	public void setContent_kicker(String kicker) {
		this.content_kicker = content_kicker;
	}
	public String getPrint_headline() {
		return print_headline;
	}
	public void setPrint_headline(String print_headline) {
		this.print_headline = print_headline;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	public static HeadLine setAllHeadLineData(JSONObject headlineData) {
		HeadLine headline = new HeadLine();
		if(headlineData != null) {
			if(headlineData.get("main")!=null && !(headlineData.get("main").toString().isEmpty())) 
				headline.setMain(headlineData.get("main").toString());
			if(headlineData.get("kicker")!=null && !(headlineData.get("kicker").toString().isEmpty())) 
				headline.setKicker(headlineData.get("kicker").toString());
			if(headlineData.get("content_kicker")!=null && !(headlineData.get("content_kicker").toString().isEmpty())) 
				headline.setContent_kicker(headlineData.get("content_kicker").toString());
			if(headlineData.get("print_headline")!=null && !(headlineData.get("print_headline").toString().isEmpty())) 
				headline.setPrint_headline(headlineData.get("print_headline").toString());
			if(headlineData.get("seo")!=null && !(headlineData.get("seo").toString().isEmpty())) 
				headline.setSeo(headlineData.get("seo").toString());
			if(headlineData.get("sub")!=null && !(headlineData.get("sub").toString().isEmpty())) 
				headline.setSub(headlineData.get("sub").toString());
		}
		return headline;
	}
}
