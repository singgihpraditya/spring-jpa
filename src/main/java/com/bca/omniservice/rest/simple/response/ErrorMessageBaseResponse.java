package com.bca.omniservice.rest.simple.response;

public class ErrorMessageBaseResponse {
	private String indonesian;
	private String english;

	public ErrorMessageBaseResponse() {
	}

	public ErrorMessageBaseResponse(String indonesian, String english) {
		this.indonesian = indonesian;
		this.english = english;
	}

	public String getIndonesian() {
		return indonesian;
	}

	public void setIndonesian(String indonesian) {
		this.indonesian = indonesian;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

}
