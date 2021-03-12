package com.example.demo.order;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String orderer; // 주문자
	private String orderedProduct; // 주만상품
	private String orderedQuantity; // 주문수량
	private String paymentAmount; // 결제금액
	private boolean isPayment;
	private Date orderedDate;
	
	public Order() {}
	public Order(int num, String orderer, String orderedProduct, String orderedQuantity, String paymentAmount,
			boolean isPayment, Date orderedDate) {
		this.num = num;
		this.orderer = orderer;
		this.orderedProduct = orderedProduct;
		this.orderedQuantity = orderedQuantity;
		this.paymentAmount = paymentAmount;
		this.isPayment = isPayment;
		this.orderedDate = orderedDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public String getOrderedProduct() {
		return orderedProduct;
	}
	public void setOrderedProduct(String orderedProduct) {
		this.orderedProduct = orderedProduct;
	}
	public String getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(String orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public boolean isPayment() {
		return isPayment;
	}
	public void setPayment(boolean isPayment) {
		this.isPayment = isPayment;
	}
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	@Override
	public String toString() {
		return "Order [num=" + num + ", orderer=" + orderer + ", orderedProduct=" + orderedProduct
				+ ", orderedQuantity=" + orderedQuantity + ", paymentAmount=" + paymentAmount + ", isPayment="
				+ isPayment + ", orderedDate=" + orderedDate + "]";
	}
	
	
}
