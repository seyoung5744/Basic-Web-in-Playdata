package com.example.demo.down;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class DownFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String writer;
	private String content;
	private String path;
	private String pwd;
	private int cnt;

	@Transient // 테이블 생성에서 제외
	private MultipartFile file;

	public DownFile() {
	}

	public DownFile(int num, String title, String writer, String content, String path, String pwd, int cnt,
			MultipartFile file) {

		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.path = path;
		this.pwd = pwd;
		this.cnt = cnt;
		this.file = file;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "DownFile [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content + ", path="
				+ path + ", cnt=" + cnt + ", file=" + file + "]";
	}

}
