package com.bca.omniservice.rest.simple.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("simple")
public class SimpleRestConfig {
	private String customerUrl;
	private Integer clientTimeOut;
	private long memoryHeapAlertPercentage;

	public String getCustomerUrl() {
		return customerUrl;
	}

	public void setCustomerUrl(String customerUrl) {
		this.customerUrl = customerUrl;
	}

	public Integer getClientTimeOut() {
		return clientTimeOut;
	}

	public void setClientTimeOut(Integer clientTimeOut) {
		this.clientTimeOut = clientTimeOut;
	}

	public long getMemoryHeapAlertPercentage() {
		return memoryHeapAlertPercentage;
	}

	public void setMemoryHeapAlertPercentage(long memoryHeapAlertPercentage) {
		this.memoryHeapAlertPercentage = memoryHeapAlertPercentage;
	}

}
