package com.waa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waa.domain.Customer;
import com.waa.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customer", method = RequestMethod.GET)
	public String getCustomerLoginForm(@ModelAttribute("newCustomer") Customer newCustomer){
		
		return "customer";
		
	}
	
	@RequestMapping(value="/customer", method =RequestMethod.POST)
	public String processCustomerLoginForm(@ModelAttribute("newCustomer") @Valid Customer newCustomer, BindingResult result){
		if(result.hasErrors()){
			return "customer";
		}
		customerService.addCustomer(newCustomer);
		return "redirect:/customers";
	}
	
	@RequestMapping(value="/customers", method =RequestMethod.GET)
	public String getAllCustomers(Model model){
		model.addAttribute("customers", customerService.getAllCustomer());
		return "customers";
	}

}
