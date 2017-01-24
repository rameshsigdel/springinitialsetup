package com.waa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.waa.domain.Product;

@Service
public interface ProductService {
	public void addProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(String productId);
	public boolean updateProduct(String productId, Product product);
	public boolean deleteProduct(String productId);
	//public boolean editProductById(String productId, Product product);
}
