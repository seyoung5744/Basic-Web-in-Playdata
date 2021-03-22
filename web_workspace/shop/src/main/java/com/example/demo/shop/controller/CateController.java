package com.example.demo.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.shop.model.Category;
import com.example.demo.shop.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cates")
public class CateController {

	@Autowired
	private CategoryService service;

	@GetMapping("")
	public Map getAll() {
		boolean flag = false;
		Map map = new HashMap();
		try {
			ArrayList<Category> list = service.getList();
			map.put("list", list);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
}
