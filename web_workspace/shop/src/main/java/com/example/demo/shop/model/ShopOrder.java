package com.example.demo.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class ShopOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	@ManyToOne
	@JoinColumn(name = "prod") // fk설정. 맵핑된 멤버 변수 타입 entity 테이블의 primary key에 연결. 만약 primary key가 여러개면
								// referencedColumnName=컬럼명으로 상세 지정할 수 있음.
	private Product prod;

	@ManyToOne
	@JoinColumn(name = "consumer")
	private ShopMember consumer;

	private int amount;
	private int payment;// 결제금액
	private boolean pay;// 결제유무
	private Date order_date;// 주문날짜

	@PrePersist
	public void beforeCreate() {
		order_date = new Date();
	}

	public ShopOrder() {
	}

	public ShopOrder(int num, Product prod, ShopMember consumer, int amount, int payment, boolean pay,
			Date order_date) {
		this.num = num;
		this.prod = prod;
		this.consumer = consumer;
		this.amount = amount;
		this.payment = payment;
		this.pay = pay;
		this.order_date = order_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public ShopMember getConsumer() {
		return consumer;
	}

	public void setConsumer(ShopMember consumer) {
		this.consumer = consumer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "ShopOrder [num=" + num + ", prod=" + prod + ", consumer=" + consumer + ", amount=" + amount
				+ ", payment=" + payment + ", pay=" + pay + ", order_date=" + order_date + "]";
	}

}
