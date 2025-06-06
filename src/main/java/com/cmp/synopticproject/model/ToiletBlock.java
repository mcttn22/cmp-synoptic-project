package com.cmp.synopticproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class to represent toilet block entities in database via ORM.
 */
@Entity
public class ToiletBlock {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer blockId;
	private String blockAddress;
	private String blockStatus;
	private Integer toiletCount;

	public Integer getBlockId () {
		return this.blockId;
	}

	public void setBlockId (Integer blockId) {
		this.blockId = blockId;
	}

	public String getBlockAddress () {
		return this.blockAddress;
	}

	public void setBlockAddress (String blockAddress) {
		this.blockAddress = blockAddress;
	}

	public String getBlockStatus () {
		return this.blockStatus;
	}

	public void setBlockStatus (String blockStatus) {
		this.blockStatus = blockStatus;
	}

	public Integer getToiletCount () {
		return this.toiletCount;
	}

	public void setToiletCount (Integer toiletCount) {
		this.toiletCount = toiletCount;
	}
}

