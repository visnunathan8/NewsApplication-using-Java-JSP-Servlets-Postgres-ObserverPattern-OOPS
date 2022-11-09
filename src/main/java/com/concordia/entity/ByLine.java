package com.concordia.entity;

import org.json.simple.JSONObject;

public class ByLine {
	int bylineId;
	String original;
	String organisation;
	
	public int getByLineId() {
		return bylineId;
	}
	public void setByLineId(int bylineId) {
		bylineId = bylineId;
	}
	
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	
	Person person;
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public static ByLine setAllByLineData(JSONObject byLineData) {
		ByLine byLine = new ByLine();
		if(byLineData != null) {
			if(byLineData.get("original")!=null && !(byLineData.get("original").toString().isEmpty()))
				byLine.setOriginal( ( byLineData.get("original")).toString());
			if(byLineData.get("organisation")!=null && !(byLineData.get("organisation").toString().isEmpty()))
				byLine.setOrganisation( ( byLineData.get("organisation")).toString());
			
			}
	
		return byLine;
	}

}
