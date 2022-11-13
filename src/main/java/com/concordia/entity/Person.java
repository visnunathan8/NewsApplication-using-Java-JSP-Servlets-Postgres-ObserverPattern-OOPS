package com.concordia.entity;

import org.json.simple.JSONObject;

public class Person {

	int personId;
	int rank;
	String firstname;
	String middlename;
	String lastname;
	String qualifier;
	String title;
	String role;
	String organisation;
	

	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getMiddleName() {
		return middlename;
	}
	
	public void setMiddleName(String middlename) {
		this.middlename = middlename;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getQualifier() {
		return qualifier;
	}
	
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getOrganisation() {
		return organisation;
	}
	
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	
	/**
	 * 
	 * @param personData
	 * @return Person object with all the data in it
	 */
	public static Person setAllPersonData(JSONObject personData) {
		
		Person person = new Person();
		
		if(personData != null) {
			
			if(personData.get("firstname")!=null && !(personData.get("firstname").toString().isEmpty())) {
				person.setFirstName( ( personData.get("firstname")).toString());
			}
			
			if(personData.get("lastname")!=null && !(personData.get("lastname").toString().isEmpty())) {
				person.setLastName( ( personData.get("lastname")).toString());
			}
			
			if(personData.get("middlename")!=null && !(personData.get("middlename").toString().isEmpty())) {
				person.setMiddleName( ( personData.get("middlename")).toString());
			}
			
			if(personData.get("organisation")!=null && !(personData.get("organisation").toString().isEmpty())) {
				person.setOrganisation( ( personData.get("organisation")).toString());
			}
			
			if(personData.get("qualifier")!=null && !(personData.get("qualifier").toString().isEmpty())) {
				person.setQualifier( ( personData.get("qualifier")).toString());
			}
			
			if(personData.get("title")!=null && !(personData.get("title").toString().isEmpty())) {
				person.setTitle( ( personData.get("title")).toString());
			}
			
			if(personData.get("title")!=null && !(personData.get("title").toString().isEmpty())) {
				person.setTitle( ( personData.get("title")).toString());
			}
			
		}
		return person;
	}
}
