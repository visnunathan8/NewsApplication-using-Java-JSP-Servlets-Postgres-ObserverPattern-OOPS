package com.concordia.entity;

public class MultiMedia {
	int MultimediaId;
	String type;
	String src;
	Integer width;
	Integer height;
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
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
}
