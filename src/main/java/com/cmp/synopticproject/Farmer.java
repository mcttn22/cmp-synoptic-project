package com.cmp.synopticproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Class to represent farmer entities in database via ORM.
 */
@Entity
public class Farmer {
	private @Id @GeneratedValue Integer farmerId;
	private int resId;

	public int getFarmerId () {
		return this.farmerId;
	}

	public void setFarmerId (int farmerId) {
		this.farmerId = farmerId;
	}

	public int getResId () {
		return this.resId;
	}

	public void setResId (int resId) {
		this.resId = resId;
	}
}

