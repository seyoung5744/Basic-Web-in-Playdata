package com.example.demo.mem;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired // 의존성 자동 주입
	private MemberDao dao; // spring은 자동으로 객체를 생성해주기 때문에 오류 발생 암함.
	
	public void addMember(Member m) {
		dao.insert(m);
	}
	public Member getMember(String id){
		return dao.select(id);
	}
	public ArrayList<Member> getAll(){
		return dao.selectAll();
	}
	public void editMember(Member m){
		dao.update(m);
	}
	public void delMember(String id){
		dao.delete(id);
	}
	public boolean login(String id, String pwd){
		// TODO Auto-generated method stub
		boolean flag = false;
		Member m = getMember(id);
		if (m != null && pwd.equals(m.getPwd())) {
			flag = true;
		}
		return flag;
	}
}
