package com.cmp.synopticproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class to represent toilet entities in database via ORM.
 */
@Entity
public class Toilet {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer toiletId;
	private Integer blockId;
	private String toiletStatus;
	private String compostStatus;

	public Integer getToiletId () {
		return this.toiletId;
	}

	public void setToiletId (Integer toiletId) {
		this.toiletId = toiletId;
	}

	public Integer getBlockId () {
		return this.blockId;
	}

	public void setBlockId (Integer blockId) {
		this.blockId = blockId;
	}

	public String getToiletStatus () {
		return this.toiletStatus;
	}

	public void setToiletStatus (String toiletStatus) {
		this.toiletStatus = toiletStatus;
	}

	public String getCompostStatus () {
		return this.toiletStatus;
	}

	public void setCompostStatus (String compostStatus) {
		this.compostStatus = compostStatus;
	}
}

