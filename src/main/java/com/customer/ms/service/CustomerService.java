package com.customer.ms.service;

import java.util.List;

import com.customer.ms.model.CustomerM;

public interface CustomerService {

	List<CustomerM> findAll();
	
	CustomerM findById(String cusid);
	
	CustomerM addCustomer(CustomerM customer);
	
	void deleteCustomer(String custId);
}
