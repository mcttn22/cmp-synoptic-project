package com.cmp.synopticproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class to represent report entities in database via ORM.
 */
@Entity
public class Report {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer reportId;
	private String firstName;
	private String lastName;
	private String email;
	private String blockAddress;
	private String description;

	public Integer getReportId () {
		return this.reportId;
	}

	public void setReportId (Integer reportId) {
		this.reportId = reportId;
	}

	public String getFirstName () {
		return this.firstName;
	}

	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public String getLastName () {
		return this.lastName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public String getEmail () {
		return this.email;
	}

	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getBlockAddress () {
		return this.blockAddress;
	}

	public void setBlockAddress (String blockAddress) {
		this.blockAddress = blockAddress;
	}

	public String getDescription () {
		return this.description;
	}

	public void setDescription (String description) {
		this.description = description;
	}
}

