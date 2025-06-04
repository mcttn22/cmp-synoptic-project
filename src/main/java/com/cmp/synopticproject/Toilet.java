package com.cmp.synopticproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Class to represent toilet entities in database via ORM.
 */
@Entity
public class Toilet {
	private @Id @GeneratedValue Integer toiletId;
	private int blockId;
	private String toiletStatus;

	public int getToiletId () {
		return this.toiletId;
	}

	public void setToiletId (int id) {
		this.toiletId = toiletId;
	}

	public int getBlockId () {
		return this.blockId;
	}

	public void setBlockId (int blockId) {
		this.blockId = blockId;
	}

	public String getToiletStatus () {
		return this.toiletStatus;
	}

	public void setToiletStatus (String toiletStatus) {
		this.toiletStatus = toiletStatus;
	}
}

