package com.concordia.entity;

import org.json.simple.JSONObject;

public class Media {

	int mediaId;
	int rank;
	int width;
	int height;
	String type;
	String subtype;
	String caption;
	String url;
	String crop_name;;
	
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSubType() {
		return subtype;
	}
	public void setSubType(String type) {
		this.subtype = subtype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCrop_name() {
		return url;
	}
	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}
	
	public static Media setAllMediaData(JSONObject MediaData) {
		Media media = new Media();
		if(MediaData != null) {
			if(MediaData.get("rank")!=null && !(MediaData.get("rank").toString().isEmpty()))
				media.setRank( ((Long) MediaData.get("rank")).intValue());
			if(MediaData.get("type")!=null && !(MediaData.get("type").toString().isEmpty()))
				media.setType(MediaData.get("type").toString());
			if(MediaData.get("subtype")!=null && !(MediaData.get("subtype").toString().isEmpty()))
				media.setSubType(MediaData.get("subtype").toString());
			if(MediaData.get("caption")!=null && !(MediaData.get("caption").toString().isEmpty()))
				media.setCaption(MediaData.get("caption").toString());
			if(MediaData.get("width")!=null && !(MediaData.get("width").toString().isEmpty()))
				media.setWidth( ((Long) MediaData.get("width")).intValue());
			if(MediaData.get("height")!=null && !(MediaData.get("height").toString().isEmpty()))
				media.setHeight( ((Long) MediaData.get("height")).intValue());
			if(MediaData.get("url")!=null && !(MediaData.get("url").toString().isEmpty()))
				media.setUrl(MediaData.get("url").toString());
			if(MediaData.get("crop_name")!=null && !(MediaData.get("crop_name").toString().isEmpty()))
				media.setCrop_name(MediaData.get("crop_name").toString());
		}
		return media;
	}

}
