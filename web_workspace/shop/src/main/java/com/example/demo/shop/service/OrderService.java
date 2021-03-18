package com.example.demo.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.shop.model.ShopOrder;
import com.example.demo.shop.model.ShopOrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private ShopOrderRepository repos;
	
	public void addOrder(ShopOrder so) {
		repos.save(so);
	}
	
	public ArrayList<ShopOrder> getAll(){
		return (ArrayList<ShopOrder>) repos.findAll();
	}
	
	public boolean delOrder(int num) {
		ShopOrder so = repos.getOne(num);
		if(so.isPay()) {
			return false;
		}else {
			repos.deleteById(num);
			return true;
		}
	}
	
	public boolean pay(int num) {
		ShopOrder so = repos.getOne(num);
		if(so.isPay()) {
			return false;
		}else {
			so.setPay(true);
			repos.updatePay(num);
			return true;
		}
	}
}
