package com.concordia.entity;

import org.json.simple.JSONObject;

public class MultiMedia {
	int MultimediaId;
	String type;
	String src;
	int width;
	int height;
	String credit;
	
	
	public int getMultimediaId() {
		return MultimediaId;
	}
	public void setMultimediaId(int multimediaId) {
		MultimediaId = multimediaId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
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
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public static MultiMedia setAllMultimediaData(JSONObject multimediaData) {
		MultiMedia multimedia = new MultiMedia();
		if(multimediaData != null) {
			if(multimediaData.get("type")!=null && !(multimediaData.get("type").toString().isEmpty()))
				multimedia.setType(multimediaData.get("type").toString());
			if(multimediaData.get("src")!=null && !(multimediaData.get("src").toString().isEmpty()))
				multimedia.setSrc(multimediaData.get("src").toString());
			if(multimediaData.get("width")!=null && !(multimediaData.get("width").toString().isEmpty()))
				multimedia.setWidth( ((Long) multimediaData.get("width")).intValue());
			if(multimediaData.get("height")!=null && !(multimediaData.get("height").toString().isEmpty()))
				multimedia.setHeight( ((Long) multimediaData.get("height")).intValue());
			if(multimediaData.get("credit")!=null && !(multimediaData.get("credit").toString().isEmpty()))
				multimedia.setCredit(multimediaData.get("credit").toString());
		}
		return multimedia;
	}
}
