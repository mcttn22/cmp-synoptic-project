package com.cmp.synopticproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Class to represent resident entities in database via ORM.
 */
@Entity
public class Resident {
	private @Id @GeneratedValue Integer resId;
	private String username;
	private String password;
	private String fullName;
	private String address;

	public int getResId () {
		return this.resId;
	}

	public void setResId (int resId) {
		this.resId = resId;
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

	public String getFullName () {
		return this.fullName;
	}

	public void setFullName (String fullName) {
		this.fullName = fullName;
	}

	public String getAddress () {
		return this.address;
	}

	public void setAddress (String address) {
		this.address = address;
	}
}

