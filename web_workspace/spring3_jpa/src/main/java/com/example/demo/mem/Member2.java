package com.example.demo.mem;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.board.Board2;

@Entity // 클래스 이름과 동일한 테이블 만듦.
public class Member2 {
	@Id // primary key 지정 
	private String id;
	private String pwd;
	private String name;
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "writer", cascade = CascadeType.REMOVE) // cascade = CascadeType.REMOVE : 글 작성자가 탈퇴할때 해당 아이디와 연결된 게시글도 삭제
	// 다른 테이블과 관계를 명시.
	// 1:1관계 =>@OneToOne
	// 1:다관계 =>@OneToMany
	// 다:1관계 =>@ManyToOne
	// 다:다관계 =>@ManyToMany
	private List<Board2> list;

	public Member2() {
	}

	public Member2(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public List<Board2> getList() {
		return list;
	}

	public void setList(List<Board2> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + "]";
	}

}
