package com.concordia.entity;

public class UserAccount {
	int userId;
	protected String username;
	protected String password;
	protected String userEmail;
	protected String userMobile;
	protected String userType;

	public UserAccount() {

	}

	public UserAccount(String username, String password, String userEmail, String userMobile, String userType) {
		this.username = username;
		this.password = password;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
