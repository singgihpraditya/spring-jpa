package com.bca.omniservice.rest.simple.response.customer;

import com.bca.omniservice.rest.simple.response.BaseOutputSchema;
import com.bca.omniservice.rest.simple.response.BaseResponse;

public class SimpleRestResponse<T extends BaseOutputSchema> extends BaseResponse{
	private T outputSchema;

	public SimpleRestResponse() {
	}
	
	public SimpleRestResponse(BaseResponse baseResponse, T outputSchema) {
		this.setResponse(baseResponse);
		this.outputSchema = outputSchema;
	}

	public SimpleRestResponse(BaseResponse baseResponse, T outputSchema,
			Integer httpStatusCode) {
		this.setResponse(baseResponse);
		this.outputSchema = outputSchema;
		this.httpStatusCode = httpStatusCode;
	}

	public T getOutputSchema() {
		return outputSchema;
	}

	public void setOutputSchema(T outputSchema) {
		this.outputSchema = outputSchema;
	}
}
