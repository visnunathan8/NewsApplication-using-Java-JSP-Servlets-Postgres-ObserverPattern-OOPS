package com.concordia.entity;

import org.json.simple.JSONObject;

public class MovieLink {
	int Linkid;
	String Type;
	String URL;
	String suggested_link_text;
	
	
	public int getLinkid() {
		return Linkid;
	}
	public void setLinkid(int linkid) {
		Linkid = linkid;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getSuggested_link_text() {
		return suggested_link_text;
	}
	public void setSuggested_link_text(String suggested_link_text) {
		this.suggested_link_text = suggested_link_text;
	}
	public static MovieLink setAllMovieLinkData(JSONObject linkData) {
		MovieLink movielink = new MovieLink();
		if(linkData != null) {
			if(linkData.get("type")!=null && !(linkData.get("type").toString().isEmpty())) 
				movielink.setType(linkData.get("type").toString());
			if(linkData.get("url")!=null && !(linkData.get("url").toString().isEmpty())) 
				movielink.setURL(linkData.get("url").toString());
			if(linkData.get("suggested_link_text")!=null && !(linkData.get("suggested_link_text").toString().isEmpty())) 
				movielink.setSuggested_link_text(linkData.get("suggested_link_text").toString());	
		}
		return movielink;
	}
}
