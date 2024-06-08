package org.example.bean;

public class NingxhBean {
	private String name;

	public NingxhBean(String name) {
		this.name = "nignxh";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NingxhBean() {
		System.out.println("构造函数启动");
	}
}
