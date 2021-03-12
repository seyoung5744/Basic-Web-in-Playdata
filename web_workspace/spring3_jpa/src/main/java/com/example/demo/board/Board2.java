package com.example.demo.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.example.demo.mem.Member2;

@Entity
public class Board2 {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 값 자동 생성
	private int num;

	// 1:1관계 =>@OneToOne
	// 1:다관계 =>@OneToMany
	// 다:1관계 =>@ManyToOne
	// 다:다관계 =>@ManyToMany

	@ManyToOne
	@JoinColumn(name = "writer", nullable = false) // form에 작성자가 써있지 않으면 insert불가능
	private Member2 writer;
	private Date w_date;
	private String title;
	private String content;

	@PrePersist
	public void beforeCreate() {
		w_date = new Date();
	}

	public Board2() {
	}

	public Board2(int num, Member2 writer, Date w_date, String title, String content) {
		this.num = num;
		this.writer = writer;
		this.w_date = w_date;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Member2 getWriter() {
		return writer;
	}

	public void setWriter(Member2 writer) {
		this.writer = writer;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
