package com.webstore.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.webstore.domain.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	private final List<Product> listOfProduct;
	public InMemoryProductRepository() {
	listOfProduct = new ArrayList<>();
	
	Product iphone = new Product();
	iphone.setProductId("iph123");
	iphone.setCategory("Iphone");
	iphone.setUnitsInStock(500);
	iphone.setDescription("This is the iphone desc.");
	listOfProduct.add(iphone);
	Product samsung = new Product();
	samsung.setProductId("smg123");
	samsung.setCategory("Samsung");
	samsung.setUnitsInStock(300);
	samsung.setDescription("This is description of Samsung mobile phone.");
	listOfProduct.add(samsung);
	}
	@Override
	public List<Product> getAllProducts() {
	return listOfProduct;
	}
	@Override
	public Product getProductById(String productId) {
		Product p = null;
		for(int i=0;i<listOfProduct.size();i++){
			if(listOfProduct.get(i).getProductId().equals(productId)){
				p=listOfProduct.get(i);
			}
		}
		return p;
	}

}
