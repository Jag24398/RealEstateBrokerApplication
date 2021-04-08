package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
	
//	public Customer saveCustomer(Customer customer);
//
//	public Customer updateCustomer(Customer customer);
//
//	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
//
//	public Customer fetchCustomer(int custid) throws CustomerNotFoundException;
//
//	public List<Customer> fetchAllCustomers();
}
