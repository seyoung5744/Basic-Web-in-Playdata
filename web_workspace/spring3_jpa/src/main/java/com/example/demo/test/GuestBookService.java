package com.example.demo.test;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookService {
	@Autowired
	private GuestbookRepository repos;
	
	public void write(GuestBook gb) {
		repos.save(gb);//insert 수행(기본키값 없음)
	}
	
	public GuestBook getByNum(int num) {
		return repos.getOne(num);//id(primary key)로 한개 검색. select(기본키기준)
	}
	
	public ArrayList<GuestBook> getAll(){
		return (ArrayList<GuestBook>) repos.findAll();//selectAll
	}
	
	public void editBook(GuestBook gb) {
		repos.save(gb);//update(기본키값 있음)
	}
	
	public void delBook(int num) {
		repos.deleteById(num);//id(기본키)로 삭제
	}
	
}
