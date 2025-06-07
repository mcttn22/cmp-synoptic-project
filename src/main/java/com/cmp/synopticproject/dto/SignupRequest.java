package com.cmp.synopticproject.dto;

/**
 * Class to represent signup request body objects.
 */
public class SignupRequest {
	private String userType;
	private String username;
	private String email;
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

	public String getEmail () {
		return this.email;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public String getPassword () {
		return this.password;
	}

	public void setPassword (String password) {
		this.password = password;
	}
}

