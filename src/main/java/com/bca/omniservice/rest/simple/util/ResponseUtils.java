package com.bca.omniservice.rest.simple.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bca.omniservice.rest.simple.response.BaseOutputSchema;
import com.bca.omniservice.rest.simple.response.BaseResponse;
import com.bca.omniservice.rest.simple.response.customer.SimpleRestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResponseUtils<T extends BaseOutputSchema> {
	@Autowired
	private ObjectMapper objectMapper;
	
	public ResponseEntity generateSuccessResult(T t) {
		BaseResponse baseResponse = new BaseResponse(Constants.ErrorCode.ERROR_CODE_SUCCESS,
				Constants.ErrorCode.ERROR_MESSAGE_SUCCESS_EN,
				Constants.ErrorCode.ERROR_MESSAGE_SUCCESS_IN);
		baseResponse.setHttpStatusCode(HttpStatus.OK.value());
		t.setEpochNow();
		SimpleRestResponse<T> outputResponse = new SimpleRestResponse<T>(baseResponse, t);
//		try {
//			log.debug("Output : [{}]",objectMapper.writeValueAsString(outputResponse));
//		} catch (JsonProcessingException e) {
//			log.error("Failed parse JSON Output");
//		}
		return new ResponseEntity(outputResponse, HttpStatus.valueOf(outputResponse.getHttpStatusCode()));
	}
	
	public ResponseEntity generateFailedResult(T t, Exception ex) {
		return generateFailedResult(t, ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	public ResponseEntity generateFailedResult(T t, Exception ex, Integer httpStatusCode) {
		BaseResponse baseResponse = new BaseResponse(Constants.ErrorCode.ERROR_CODE_FAILED, ex.getMessage(),
				ex.getMessage());
		baseResponse.setHttpStatusCode(httpStatusCode);
		t.setEpochNow();
		SimpleRestResponse<T> outputResponse = new SimpleRestResponse<T>(baseResponse, t);
//		try {
//			log.debug("Output : [{}]",objectMapper.writeValueAsString(outputResponse));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			log.error("Failed parse JSON Output");
//		}
		return new ResponseEntity(outputResponse, HttpStatus.valueOf(outputResponse.getHttpStatusCode()));
	}
}
