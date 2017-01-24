package com.waa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.waa.domain.Customer;
@Service
public interface CustomerService {
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
}
