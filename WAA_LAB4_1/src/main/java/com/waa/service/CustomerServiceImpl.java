package com.waa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.waa.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
private final List<Customer> customers;

	public CustomerServiceImpl() {
		customers = new ArrayList<>();
	}

	@Override
	public void addCustomer(Customer customer) {
		customers.add(customer);

	}

	@Override
	public List<Customer> getAllCustomer() {

		return customers;
	}
}
