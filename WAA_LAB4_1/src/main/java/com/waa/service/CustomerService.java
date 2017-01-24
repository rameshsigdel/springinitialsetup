package com.waa.service;

import java.util.List;

import com.waa.domain.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
}
