package com.bca.omniservice.rest.simple.exceptionhandler;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bca.omniservice.rest.simple.response.BaseOutputSchema;
import com.bca.omniservice.rest.simple.util.Constants;
import com.bca.omniservice.rest.simple.util.ResponseUtils;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ResponseUtils<BaseOutputSchema> responseUtils;
	
	@Override
	protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		StringBuffer details = new StringBuffer();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			FieldError fieldError = (FieldError) error;
			details.append(fieldError.getField());
			details.append(" : ");
			details.append(fieldError.getDefaultMessage());
			details.append(", ");
		}
		return responseUtils.generateFailedResult(new BaseOutputSchema(), new Exception(details.toString()));
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity handleAllExceptions(Exception ex, WebRequest request) {
		log.debug(ex.getMessage());
		ex.printStackTrace();
		return responseUtils.generateFailedResult(new BaseOutputSchema(), new Exception(Constants.ErrorCode.ERROR_MESSAGE_UNDER_MAINTENANCE));
	}
}
