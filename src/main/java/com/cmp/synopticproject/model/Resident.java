package com.cmp.synopticproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class to represent resident entities in database via ORM.
 */
@Entity
public class Resident {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer resId;
	private String username;
	private String email;
	private String password;

	public Integer getResId () {
		return this.resId;
	}

	public void setResId (Integer resId) {
		this.resId = resId;
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

