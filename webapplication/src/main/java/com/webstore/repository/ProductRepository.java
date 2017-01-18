package com.webstore.repository;

import java.util.List;

import com.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
Product getProductById(String productId);
}
