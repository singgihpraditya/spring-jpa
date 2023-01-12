package com.bca.omniservice.rest.simple.response.customer;

import java.util.List;

import com.bca.omniservice.rest.simple.response.BaseOutputSchema;

public class ListCustomerOutputSchema extends BaseOutputSchema {
	private List<CustomerResponse> customerList;
	private Long totalRecord;

	public List<CustomerResponse> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerResponse> customerList) {
		this.customerList = customerList;
	}

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}
}
