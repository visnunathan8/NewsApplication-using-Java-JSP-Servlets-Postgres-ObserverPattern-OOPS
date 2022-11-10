package com.concordia.entity;

import org.json.simple.JSONObject;

public class Critic {
	
	int CriticId;
	String display_name;
	String sort_name;
	String status;
	String bio;
	String seo_name;
	int multimediaId;
	MultiMedia multimedia;
	
	public int getMultimediaId() {
		return multimediaId;
	}
	public void setMultimediaId(int multimediaId) {
		this.multimediaId = multimediaId;
	}	
	public int getCriticId() {
		return CriticId;
	}
	public void setCriticId(int criticId) {
		CriticId = criticId;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getSeo_name() {
		return seo_name;
	}
	public void setSeo_name(String seo_name) {
		this.seo_name = seo_name;
	}
	public MultiMedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(MultiMedia multimedia) {
		this.multimedia = multimedia;
	}
	
	public static Critic setAllCriticDataObject(JSONObject data) {
		Critic criticData = new Critic();
		if(data != null) {
			if(data.get("display_name")!=null && !(data.get("display_name").toString().isEmpty()))
				criticData.setDisplay_name(data.get("display_name").toString());
			if(data.get("sort_name")!=null && !(data.get("sort_name").toString().isEmpty()))
				criticData.setSort_name(data.get("sort_name").toString());
			if(data.get("status")!=null && !(data.get("status").toString().isEmpty()))
				criticData.setStatus(data.get("status").toString());
			if(data.get("bio")!=null && !(data.get("bio").toString().isEmpty()))
				criticData.setBio(data.get("bio").toString());
			if(data.get("seo_name")!=null && !(data.get("seo_name").toString().isEmpty()))
				criticData.setSeo_name(data.get("seo_name").toString());
			if(data.get("multimedia")!=null &&  !(data.get("multimedia").toString().isEmpty())) {
				JSONObject multimediaData = (JSONObject)data.get("multimedia");
				multimediaData = (JSONObject) multimediaData.get("resource");
				MultiMedia multimedia = MultiMedia.setAllMultimediaData(multimediaData);
				criticData.setMultimedia(multimedia);
			}
		}
		return criticData;
	}
}
