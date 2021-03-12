package com.example.demo.mem;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired // 의존성 자동 주입
	private MemberRepository repos;

	public void addMember(Member2 m) {
		repos.save(m);
	}

	public Member2 getMember(String id) {
		return repos.findById(id).orElse(null);//id(기본키)로 검색해서 있으면 그 객체 반환. 없으면 null을 반환
	}

	public void editMember(Member2 m) {
		repos.save(m);
	}

	public void delMember(String id) {
		repos.deleteById(id);
	}

	public boolean login(String id, String pwd) {
		boolean flag = false;
		Member2 m = getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			flag = true;
		}
		return flag;
	}
}
