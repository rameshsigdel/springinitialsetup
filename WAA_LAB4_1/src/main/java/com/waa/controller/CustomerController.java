package com.waa.controller;



import java.util.List;

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
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String getAddCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
			return "customer";
		}
		
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public String processAddCustomerForm(@ModelAttribute("newCustomer") @Valid Customer newCustomer,BindingResult result,Model model) {
			if(result.hasErrors()){
				return "customer";
			}
			
			customerService.addCustomer(newCustomer);
			return "redirect:/allCustomers";
		}
		
		@RequestMapping(value="/allCustomers", method =RequestMethod.GET)
		public String getAllCustomers(Model model){
			System.out.println("In all Customers");
			List<Customer> myCustomer = customerService.getAllCustomer();
			System.out.println(myCustomer.size());
			model.addAttribute("customers", customerService.getAllCustomer());
			
			return "allCustomerList";
		}

	}
