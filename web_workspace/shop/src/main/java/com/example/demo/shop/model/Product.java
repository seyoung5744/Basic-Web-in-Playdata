package com.example.demo.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String content;

	@ManyToOne
	@JoinColumn(name = "seller")
	private ShopMember seller;
	private int price;
	private int amount;

	@ManyToOne
	@JoinColumn(name = "cate")
	private Category cate;

	@Transient
	private MultipartFile file1;
	@Transient
	private MultipartFile file2;
	@Transient
	private MultipartFile file3;
	@Transient
	private MultipartFile file4;

	public Product() {
	}

	public Product(int num, String title, String content, ShopMember seller, int price, int amount, Category cate,
			MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.seller = seller;
		this.price = price;
		this.amount = amount;
		this.cate = cate;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
		this.file4 = file4;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ShopMember getSeller() {
		return seller;
	}

	public void setSeller(ShopMember seller) {
		this.seller = seller;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public MultipartFile getFile3() {
		return file3;
	}

	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

	public MultipartFile getFile4() {
		return file4;
	}

	public void setFile4(MultipartFile file4) {
		this.file4 = file4;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", title=" + title + ", content=" + content + ", seller=" + seller + ", price="
				+ price + ", amount=" + amount + ", cate=" + cate + ", file1=" + file1 + ", file2=" + file2 + ", file3="
				+ file3 + ", file4=" + file4 + "]";
	}

}
