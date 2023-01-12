package com.bca.omniservice.rest.simple.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bca.omniservice.rest.simple.request.customer.CustomerRequest;
import com.bca.omniservice.rest.simple.request.customer.PagingRequest;
import com.bca.omniservice.rest.simple.service.CustomerService;
import com.bca.omniservice.rest.simple.util.Utils;

@RestController
public class CustomerMaintenanceController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/consumer/inquiry", method = RequestMethod.POST)
	public ResponseEntity inquiry(@Valid @RequestBody(required = true) PagingRequest request) {
		String hashCode = Utils.getHashCodeNumber() + "-INQUIRY-DATA-";
		return customerService.listWithPaging(hashCode, request);
	}

}
