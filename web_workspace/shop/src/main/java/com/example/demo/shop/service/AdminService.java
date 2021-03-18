package com.example.demo.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.shop.model.Category;
import com.example.demo.shop.model.CategoryRepository;

@Service
public class AdminService {

	@Autowired
	private CategoryRepository repos;

	public void addCategory(Category c) {
		repos.save(c);
	}

	public ArrayList<Category> getAllCates() {
		return (ArrayList<Category>) repos.findAll();
	}

	public Category getCate(int num) {
		return repos.getOne(num);
	}

	public void delCate(int num) {
		repos.deleteById(num);
	}
}
