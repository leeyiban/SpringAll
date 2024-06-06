package com.ezplatform.mvc.bean;

public class User {
	private String id;
	private String user;
	private String password;
	private String age;

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", user='" + user + '\'' +
				", password='" + password + '\'' +
				", age='" + age + '\'' +
				'}';
	}

	public User(String id, String user, String password, String age) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
