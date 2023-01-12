package com.bca.omniservice.rest.simple.response;


public class ErrorSchemaBaseResponse {
	private String errorCode;
	private ErrorMessageBaseResponse errorMessage;

	public ErrorSchemaBaseResponse() {
		this.errorMessage = new ErrorMessageBaseResponse();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorMessageBaseResponse getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessageBaseResponse errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
