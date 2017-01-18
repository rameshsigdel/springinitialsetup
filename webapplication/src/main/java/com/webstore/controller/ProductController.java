package com.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webstore.domain.Product;
import com.webstore.repository.ProductRepository;




@Controller
public class ProductController {
	@Autowired
	ProductRepository inMemoryRepo;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		
		model.addAttribute("products",inMemoryRepo.getAllProducts());
		return "products";
		
	}
	@RequestMapping(value = "/productList/{productId}", method = RequestMethod.GET)
	public String getSingleProduct(@PathVariable("productId") String productId,Model model) {
		
		model.addAttribute("product",inMemoryRepo.getProductById(productId));
		return "productList";
		
	}
	
}
