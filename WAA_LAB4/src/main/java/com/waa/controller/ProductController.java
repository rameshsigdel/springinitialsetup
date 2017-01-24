package com.waa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waa.domain.Product;
import com.waa.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@InitBinder
	public void initalizeBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct",product);
		return "addproduct";
	}

	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		productService.addProduct(newProduct);
		return "redirect:/showproduct";

	}

	@RequestMapping(value = "/showproduct", method = RequestMethod.GET)
	public String displayProduct(Model model) {
		model.addAttribute("productList", productService.getAllProducts());
		return "showproduct";
	}

	@RequestMapping(value = "/product/edit/{productId}", method = RequestMethod.GET)
	public String editProductForm(@PathVariable String productId, Model model) {

		model.addAttribute("editProduct", productService.getProductById(productId));
		return "edit-product";

	}
	
	@RequestMapping(value = "/product/edit/{productId}", method = RequestMethod.POST)
	public String processEditProductPage(@PathVariable("productId") String productId, Model model,
			@ModelAttribute("editProduct") Product editProduct, BindingResult result) {

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		boolean checkEdit = productService.updateProduct(productId, editProduct);
		
		if(checkEdit){
			//model.addAttribute("productList", productService.getAllProducts());
			
			return "redirect:/showproduct";
		}else{
			model.addAttribute("editProduct", productService.getProductById(productId));
			return "edit-product";
		}
		
		
	}

	@RequestMapping(value = "/product/delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String productId, Model model) {

		boolean deleteStatus = productService.deleteProduct(productId);
		if (deleteStatus) {
			return "redirect:/showproduct";
		}else{
			model.addAttribute("editProduct", productService.getProductById(productId));
			return "edit-product";
		}
	}

	@RequestMapping(value = "/showproduct/{productId}", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute Product product, @PathVariable("productId") String productId, Model model,
			BindingResult result) {

		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields : "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		boolean checkEdit = productService.updateProduct(productId, product);
		if (checkEdit) {
			return "redirect:/products";

		} else {
			model.addAttribute("product", productService.getProductById(productId));
			return "edit-product";
		}

	}

}