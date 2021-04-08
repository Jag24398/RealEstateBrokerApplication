package com.cg.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;

import com.cg.exception.CustomerNotFoundException;
import com.cg.repository.ICustomerRepo;

@Service
public class ICustomerServiceImpl {
	@Autowired
	ICustomerRepo iCustomerRepo;

	public List<Customer> listAllCustomers() {
		List<Customer> customers = iCustomerRepo.findAll();

		return customers;
	}

	public Customer viewCustomer(int custid) throws CustomerNotFoundException {

		Optional<Customer> custOpt = iCustomerRepo.findById(custid);
		if (custOpt.isPresent()) {
			Customer custSaved = custOpt.get();
			return custSaved;
		} else {
			throw new CustomerNotFoundException("Customer not found with the given id :" + custid);
		}
	}

	public Customer addCustomer(Customer customer) {

		Customer custSaved = iCustomerRepo.save(customer);
		return custSaved;
	}

	public Customer editCustomer(Customer customer) {

		Customer custSaved = iCustomerRepo.save(customer);
		return custSaved;
	}

	public Customer removeCustomer(int custid) throws CustomerNotFoundException {
		Customer customer = viewCustomer(custid);
		iCustomerRepo.deleteById(custid);
		return customer;
	}

}
