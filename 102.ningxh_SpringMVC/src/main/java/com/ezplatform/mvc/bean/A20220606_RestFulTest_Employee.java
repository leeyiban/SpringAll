package com.ezplatform.mvc.bean;

public class A20220606_RestFulTest_Employee {
	private Integer id;
	private String lastName;

	private String email;
	//1 male, 0 female
	private Integer gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public A20220606_RestFulTest_Employee() {
	}

	public A20220606_RestFulTest_Employee(Integer id, String lastName, String email, Integer gender) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}
}
