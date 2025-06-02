package com.cmp.synopticproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Class to represent toilet entities in database via ORM.
 */
@Entity
public class Toilet {
	private @Id @GeneratedValue Integer id;
	private String location;	

	public String getLocation() {
		return location;
	}

	public void setLocation (String location) {
		this.location = location;
	}
}

