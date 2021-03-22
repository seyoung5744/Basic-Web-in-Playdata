package com.example.demo.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.shop.model.Category;
import com.example.demo.shop.model.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repos;
	
	public ArrayList<Category> getList(){
		return (ArrayList<Category>) repos.findAll();
	}
	
}
