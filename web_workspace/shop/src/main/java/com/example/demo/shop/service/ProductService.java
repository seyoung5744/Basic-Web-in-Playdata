package com.example.demo.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.shop.model.Category;
import com.example.demo.shop.model.Product;
import com.example.demo.shop.model.ProductRepository;
import com.example.demo.shop.model.ShopMember;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repos;

	public Product addProduct(Product p) {
		return repos.save(p);
	}

	public void editProduct(Product p) {
		repos.save(p);
	}

	public void delProduct(int num) {
		repos.deleteById(num);
	}

	public ArrayList<Product> getAll() {
		return (ArrayList<Product>) repos.findAll();
	}

	public Product getProduct(int num) {
		return repos.getOne(num);
	}

	public ArrayList<Product> getByCate(Category c) {
		return repos.findByCate(c);
	}

	public ArrayList<Product> getBySeller(ShopMember seller) {
		return repos.findBySeller(seller);
	}

}
