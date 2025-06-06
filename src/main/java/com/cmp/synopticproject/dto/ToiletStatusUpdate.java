package com.cmp.synopticproject.dto;

/**
 * Class to represent request to update status of toilet.
 */
public class ToiletStatusUpdate {
	private String toiletStatus;

	public String getToiletStatus () {
		return this.toiletStatus;
	}

	public void setToiletStatus (String toiletStatus) {
		this.toiletStatus = toiletStatus;
	}
}

