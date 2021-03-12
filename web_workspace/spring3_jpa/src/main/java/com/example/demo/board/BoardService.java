package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repos;
	
	public void writeBoard(Board2 b) {
		repos.save(b);
	}
	public Board2 getBoard(int num){
		return repos.getOne(num);
	}
	public ArrayList<Board2> getByTitle(String title){
		return repos.findByTitleLike(title);
	}
	
	public ArrayList<Board2> getAll(){
		return (ArrayList<Board2>) repos.findAll();
	}
	public void editBoard(Board2 b){
		repos.save(b);
	}
	public void delBoard(int num){
		repos.deleteById(num);
	}
}
