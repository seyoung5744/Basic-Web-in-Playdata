package com.example.demo.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemberType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String name;
	
	// admin, seller, consumer
	public MemberType() {
	}

	public MemberType(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberType [num=" + num + ", name=" + name + "]";
	}

}
