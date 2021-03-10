package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgService {
	
	@Autowired
	private MsgDao dao;
	
	public void addMsg(MsgVo mv) {
		dao.insert(mv);
	}
	
	public MsgVo getMsg(int num) {
		return dao.select(num);
	}
	
	public ArrayList<MsgVo> getAll(){
		return dao.selectAll();
	}
	
	public void editMsg(MsgVo mv) {
		dao.update(mv);
	}
	
	public void delMsg(int num) {
		dao.delete(num);
	}
}
