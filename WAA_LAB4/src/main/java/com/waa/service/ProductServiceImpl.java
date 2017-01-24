package com.waa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.waa.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	public final List<Product> listOfProduct = new ArrayList<>();

	public ProductServiceImpl() {
		
		Product iPhone = new Product();
		
		iPhone.setName("IPhone 5S");
		iPhone.setProductId("IP123");

		Long l = new Long(500);
		iPhone.setUnitPrice(BigDecimal.valueOf(l));
		iPhone.setUnitsInStock(150);
		iPhone.setDescription("New IPhone 5S released on Nov 22, 2011.");
		iPhone.setManufacturer("Apple");
		iPhone.setCategory("Phone Gadget");
		iPhone.setCondition("New");

		Product iPad = new Product();

		iPad.setName("IPad 3");
		iPad.setProductId("ipad1234");
		Long l2 = new Long(700);
		iPad.setUnitPrice(BigDecimal.valueOf(l2));
		iPad.setUnitsInStock(100);
		iPad.setDescription("New IPad 3 released on Jan 14, 2012.");
		iPad.setManufacturer("Apple");
		iPad.setCategory("Pad Gadget");
		iPad.setCondition("Refurnished");
		
		listOfProduct.add(iPhone);
		listOfProduct.add(iPad);

	}

	/*
	 * @Override public void addProductToList(Product product){
	 * 
	 * List<Product> productList = new ArrayList<Product>();
	 * listOfProduct.add(product); }
	 */

	@Override
	public void addProduct(Product product) {
		listOfProduct.add(product);

	}

	@Override
	public List<Product> getAllProducts() {

		return listOfProduct;
	}

	@Override
	public Product getProductById(String productId) {
		for (Product p : listOfProduct) {
			if (p.getProductId().equals(productId)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean updateProduct(String productId, Product product) {
		boolean success  = false;
		//Product p = this.getProductById(productId);
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (listOfProduct.get(i).getProductId().equals(productId)) {

				listOfProduct.get(i).setProductId(product.getProductId());
				listOfProduct.get(i).setName(product.getName());
				listOfProduct.get(i).setUnitPrice(product.getUnitPrice());
				listOfProduct.get(i).setDescription(product.getDescription());
				listOfProduct.get(i).setManufacturer(product.getManufacturer());
				listOfProduct.get(i).setCategory(product.getCategory());
				listOfProduct.get(i).setUnitsInStock(product.getUnitsInStock());

				success = true;
			}
		}
		return success;

	}

	@Override
	public boolean deleteProduct(String productId) {
		boolean deleteSuccess = false;
		Product p = this.getProductById(productId);
		for (int i = 0; i < listOfProduct.size(); i++) {
			if (p.getProductId().equals(productId)) {
				listOfProduct.remove(i);
				deleteSuccess = true;
			}

		}
		return deleteSuccess;

	}

	
}
