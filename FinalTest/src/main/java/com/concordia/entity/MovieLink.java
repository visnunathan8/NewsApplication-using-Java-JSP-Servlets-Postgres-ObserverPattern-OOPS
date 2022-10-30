package com.concordia.entity;

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
	
}
