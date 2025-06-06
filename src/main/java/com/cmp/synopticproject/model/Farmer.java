package com.cmp.synopticproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class to represent farmer entities in database via ORM.
 */
@Entity
public class Farmer {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer farmerId;
	private Integer resId;

	public Integer getFarmerId () {
		return this.farmerId;
	}

	public void setFarmerId (Integer farmerId) {
		this.farmerId = farmerId;
	}

	public Integer getResId () {
		return this.resId;
	}

	public void setResId (Integer resId) {
		this.resId = resId;
	}
}

