package com.example.demo.upload;

import org.springframework.web.multipart.MultipartFile;

public class ImgVo {
	private String title;
	private MultipartFile file;
	
	
	public ImgVo() {}
	public ImgVo(String title, MultipartFile file) {
		this.title = title;
		this.file = file;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "ImgVo [title=" + title + ", file=" + file + "]";
	}
	
	
}
