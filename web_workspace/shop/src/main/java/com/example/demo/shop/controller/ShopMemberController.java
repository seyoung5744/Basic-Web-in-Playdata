package com.example.demo.shop.controller;

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
import com.example.demo.shop.service.ShopMemberService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/shop-members")//이 컨트롤러의 기본 uri
public class ShopMemberController {

	@Autowired
	private ShopMemberService service;

	@PostMapping("")//회원가입
	public Map join(ShopMember sm) {
		boolean flag = false;
		try {
			service.addMember(sm);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		//처리 결과값
		Map map = new HashMap();//맵 하나가 객체 하나. 
		map.put("result", flag);
		map.put("join_id", sm.getId());
		return map;
	}
	
	@GetMapping("/{id}")//id로 검색
	public Map getMember(@PathVariable("id") String id) {
		Map model = new HashMap();
		ShopMember m = service.getMember(id);
		boolean result = false;
		try {
			m.getPwd();
			result = true;
		} catch (Exception e) {
			System.out.println("아이디 불일치");
		}
		model.put("result", result);
		if (result) {
			System.out.println(m);
			model.put("data", m);
		}
		return model;
	}
	
	@PutMapping("")
	public Map editMember(ShopMember sm) {		
		boolean flag = false;
		ShopMember x = null;
		Map map = new HashMap();//맵 하나가 객체 하나. 
		try {
			service.editMember(sm);			
			x = service.getMember(sm.getId());
			map.put("edit_m", x);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		//처리 결과값	
		map.put("result", flag);		
		return map;		
	}
	
	@DeleteMapping("/{id}")
	public Map delMember(@PathVariable("id") String id) {
		boolean flag = false;
		try {
			service.delMember(id);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		//처리 결과값
		Map map = new HashMap();//맵 하나가 객체 하나. 
		map.put("result", flag);
		return map;
	}
}