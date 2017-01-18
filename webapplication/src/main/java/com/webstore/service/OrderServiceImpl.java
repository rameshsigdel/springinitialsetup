package com.webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.domain.Product;
import com.webstore.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public void processOrder(String productId, int quantity) {
		Product orderdProduct = productRepository.getProductById(productId);
		if (orderdProduct != null) {
			if (quantity < orderdProduct.getUnitsInStock()) {
				orderdProduct.setUnitsInStock(orderdProduct.getUnitsInStock() - quantity);
			} else {
				throw new IllegalArgumentException("Something went wrong...");
			}
		}
	}

}
