package com.bca.omniservice.rest.simple.request.customer;

import javax.validation.constraints.NotBlank;



public class CustomerRequest {
	@NotBlank
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
