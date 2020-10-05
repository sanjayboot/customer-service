package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerM> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerM findById(String cusid) {

		Optional<CustomerM> opt = customerRepository.findById(cusid);
		if (opt.isPresent()) {
			return opt.get();
		} else
			return null;
	}

	@Override
	public CustomerM addCustomer(CustomerM customerM) {
		return customerRepository.save(customerM);
	}
	
	@Override
	public void deleteCustomer(String custId) {
		 	customerRepository.deleteById(custId);
	}

}
