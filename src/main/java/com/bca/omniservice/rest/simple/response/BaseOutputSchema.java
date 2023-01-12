package com.bca.omniservice.rest.simple.response;

import java.util.Date;

public class BaseOutputSchema {

	protected String epoch;

	public BaseOutputSchema() {
	}

	public void setEpochNow() {
		this.epoch = Long.toString(new Date().getTime());
	}

	public String getEpoch() {
		return epoch;
	}

	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}
}
