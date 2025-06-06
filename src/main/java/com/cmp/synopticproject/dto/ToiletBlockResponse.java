package com.cmp.synopticproject.dto;

import com.cmp.synopticproject.model.*;

import java.util.ArrayList;

/**
 * Class to represent response of getting toilet block.
 */
public class ToiletBlockResponse {
	private Integer blockId;
	private String blockAddress;
	private String blockStatus;
	private Integer toiletCount;
	private ArrayList<Toilet> toilets;

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

	public ArrayList<Toilet> getToilets () {
		return this.toilets;
	}

	public void setToilets (ArrayList<Toilet> toilets) {
		this.toilets = toilets;
	}
}

