package com.bca.omniservice.rest.simple.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bca.omniservice.rest.simple.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByEmail(String email);

	public Page<Customer> findByEmail(String email, Pageable pageable);
}
