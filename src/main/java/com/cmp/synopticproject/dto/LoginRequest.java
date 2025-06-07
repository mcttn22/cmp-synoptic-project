package com.cmp.synopticproject.dto;

/**
 * Class to represent login request body objects.
 */
public class LoginRequest {
	private String userType;
	private String username;
	private String password;

	public String getUserType () {
		return this.userType;
	}

	public void setUserType (String userType) {
		this.userType = userType;
	}

	public String getUsername () {
		return this.username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public String getPassword () {
		return this.password;
	}

	public void setPassword (String password) {
		this.password = password;
	}
}

