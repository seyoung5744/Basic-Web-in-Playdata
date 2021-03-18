package com.example.demo.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.shop.model.ShopMember;
import com.example.demo.shop.model.ShopMemberRepository;

@Service
public class ShopMemberService {

	@Autowired
	private ShopMemberRepository repos;

	public void addMember(ShopMember m) {
		repos.save(m);
	}

	public ShopMember getMember(String id) {
		return repos.findById(id).orElse(null);// id(기본키)로 검색해서 있으면 그 객체 반환. 없으면 null을 반환
	}

	public void editMember(ShopMember m) {
		repos.save(m);
	}

	public void delMember(String id) {
		repos.deleteById(id);
	}

	public boolean login(String id, String pwd) {
		boolean flag = false;
		ShopMember m = getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			flag = true;
		}
		return flag;
	}
}
