package com.example.demo.down;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownFileService {
	@Autowired
	private DownFileRepository repos;
	
	//업로드. 다운로드. 조회. 삭제
	public void upload(DownFile df) {
		repos.save(df);
	}
	
	public DownFile getFile(int num) {
		return repos.getOne(num);
	}
	
	public void delFile(int num) {
		repos.deleteById(num);
	}
	
	public ArrayList<DownFile> getAll(){
		return (ArrayList<DownFile>) repos.findAll();
	}
	
	public void cntUpdate(int num) {
		repos.updateCnt(num);
	}
}

