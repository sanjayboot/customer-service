package com.customer.ms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;

@RestController
//added the annotation for request.
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot 1.0";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> getCustomers() {
		List<Customer> list = customerDAO.getAllCustomers();

		return list;
	}

	@RequestMapping(value = "/customers/{cusId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Customer getCustomer(@PathVariable("cusId") String cusId) {
		return customerDAO.getCustomer(cusId);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerDAO.addCustomer(customer);
	}

	@RequestMapping(value = "/customers/{cusId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void deleteCustomer(@PathVariable("cusId") String cusId) {
		customerDAO.removeCustomer(cusId);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerDAO.updateCustomer(customer);
	}

	@RequestMapping(value = "/mangoCustomers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerM> getMangoCustomers() {
		List<CustomerM> list = customerService.findAll();
		return list;
	}
	
	@RequestMapping(value = "/mangocustomers/{cusId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CustomerM getMangoCustomer(@PathVariable("cusId") String cusId) {
		return customerService.findById(cusId);
	}
	
	@RequestMapping(value = "/mangocustomers", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CustomerM addMangoCustomer(@RequestBody CustomerM customerM) {
		return customerService.addCustomer(customerM);
	}
	
	@RequestMapping(value = "/mangocustomers", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CustomerM updatMongoCustomer(@RequestBody CustomerM customerM) {
		return customerService.addCustomer(customerM);
	}

	@RequestMapping(value = "/mangocustomers/{cusId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public void deleteMangoCustomer(@PathVariable("cusId") String cusId) {
		customerService.deleteCustomer(cusId);
	}
	
}
