package com.example.demo.shop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ShopMember { // SHOP_MEMBER
	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;

	@ManyToOne // 연관관계 명시
	@JoinColumn(name="type") // member_type테이블에 조인
	private MemberType type;

	public ShopMember() {
	}

	public ShopMember(String id, String pwd, String name, String email, MemberType type) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.type = type;
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

	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ShopMember [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", type=" + type + "]";
	}

}
