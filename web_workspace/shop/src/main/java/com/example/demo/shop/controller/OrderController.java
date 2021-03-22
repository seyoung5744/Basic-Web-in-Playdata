package com.example.demo.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.shop.model.ShopMember;
import com.example.demo.shop.model.ShopOrder;
import com.example.demo.shop.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	//주문, 목록, 취소, 결제
	
	@PostMapping("")
	public Map addOrder(ShopOrder so) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			service.addOrder(so);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
	
	@GetMapping("")
	public Map getAll() {
		boolean flag = false;
		Map map = new HashMap();
		try {
			ArrayList<ShopOrder> list = service.getAll();
			map.put("list", list);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
	
	@GetMapping("/{consumer}/members")
	public Map getByConsumer(@PathVariable("consumer") String consumer) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			ShopMember m = new ShopMember();
			m.setId(consumer);
			ArrayList<ShopOrder> list = service.getByConsumer(m);
			map.put("list", list);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
	
	@DeleteMapping("/{num}")
	public Map delOrder(@PathVariable("num") int num) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			flag = service.delOrder(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
	
	@PutMapping("/{num}")
	public Map editPay(@PathVariable("num") int num) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			flag = service.pay(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
}





