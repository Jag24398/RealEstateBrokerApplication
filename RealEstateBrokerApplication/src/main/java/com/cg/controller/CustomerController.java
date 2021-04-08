package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;


import com.cg.service.ICustomerServiceImpl;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	ICustomerServiceImpl iCustomerService;

	@GetMapping
	public ResponseEntity<List<Customer>> listAllCustomers() {
		List<Customer> custList = iCustomerService.listAllCustomers();
		return new ResponseEntity<List<Customer>>(custList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") int custId) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(iCustomerService.viewCustomer(custId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(iCustomerService.addCustomer(customer), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(iCustomerService.editCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") int custid) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(iCustomerService.removeCustomer(custid), HttpStatus.OK);
	}
}
