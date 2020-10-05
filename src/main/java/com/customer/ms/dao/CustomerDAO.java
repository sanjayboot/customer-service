package com.customer.ms.dao;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

import com.customer.ms.model.Customer;

@Repository
public class CustomerDAO {

	private static final Map<String, Customer> cusMap = new HashMap<String, Customer>();

	static {
		initCus();
	}

	private static void initCus() {
		Customer cus1 = new Customer("C01", "Smith", "NY");
		Customer cus2 = new Customer("C02", "John", "NY");
		Customer cus3 = new Customer("C03", "Ethan", "NY");

		cusMap.put(cus1.getCustId(), cus1);
		cusMap.put(cus2.getCustId(), cus2);
		cusMap.put(cus3.getCustId(), cus3);

	}

	public Customer getCustomer(String custId) {
		return cusMap.get(custId);
	}

	public List<Customer> getAllCustomers() {
		Collection<Customer> c = cusMap.values();

		List<Customer> list = new ArrayList<Customer>();
		list.addAll(c);
		return list;
	}

	public Customer addCustomer(Customer cus) {
		cusMap.put(cus.getCustId(), cus);
		return cus;
	}

	public void removeCustomer(String cusId) {
		cusMap.remove(cusId);
	}

	public Customer updateCustomer(Customer cus) {
		cusMap.put(cus.getCustId(), cus);
		return cus;
	}
}
