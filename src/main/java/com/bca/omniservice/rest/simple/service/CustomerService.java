package com.bca.omniservice.rest.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bca.omniservice.rest.simple.entity.Customer;
import com.bca.omniservice.rest.simple.repository.CustomerCriteriaRepository;
import com.bca.omniservice.rest.simple.request.customer.PagingRequest;
import com.bca.omniservice.rest.simple.response.customer.CustomerResponse;
import com.bca.omniservice.rest.simple.response.customer.ListCustomerOutputSchema;
import com.bca.omniservice.rest.simple.util.ResponseUtils;

@Service
public class CustomerService {
	@Autowired
	private ResponseUtils responseUtils;
	@Autowired
	private CustomerCriteriaRepository customerRepository;

	public ResponseEntity listWithPaging(String hashCode, PagingRequest request) {
		ListCustomerOutputSchema outputSchema = new ListCustomerOutputSchema();
		
		List<Customer> customerPage = customerRepository.findByFilter(request);
		List<CustomerResponse> customerResponseList = new ArrayList<CustomerResponse>();
		for(Customer customer : customerPage) {
			CustomerResponse customerResponse = new CustomerResponse();
			customerResponse.setName(customer.getName());
			customerResponse.setDate(customer.getDate());
			customerResponse.setEmail(customer.getEmail());
			customerResponse.setId(customer.getId());
			customerResponseList.add(customerResponse);
		}
		outputSchema.setCustomerList(customerResponseList);
		
		outputSchema.setTotalRecord(customerRepository.countAll(request));
		return responseUtils.generateSuccessResult(outputSchema);
	}
}
