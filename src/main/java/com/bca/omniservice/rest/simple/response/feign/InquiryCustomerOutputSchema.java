package com.bca.omniservice.rest.simple.response.feign;

import com.bca.omniservice.rest.simple.response.BaseOutputSchema;


public class InquiryCustomerOutputSchema extends BaseOutputSchema {
	private String name;
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
