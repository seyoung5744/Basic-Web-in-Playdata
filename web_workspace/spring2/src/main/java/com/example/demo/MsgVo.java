package com.example.demo;

public class MsgVo {
	private int num;
	private String email;
	private String pwd;
	private String msg;
	
	public MsgVo() {}

	public MsgVo(int num, String email, String pwd, String msg) {
		super();
		this.num = num;
		this.email = email;
		this.pwd = pwd;
		this.msg = msg;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgVo [num=" + num + ", email=" + email + ", pwd=" + pwd + ", msg=" + msg + "]";
	}
	
	
}
