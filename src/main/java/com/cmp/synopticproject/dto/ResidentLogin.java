package com.cmp.synopticproject.dto;

/**
 * Class to represent resident login request body objects.
 */
public class ResidentLogin {
	private String username;
	private String password;

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

