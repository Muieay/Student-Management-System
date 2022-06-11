package com.zyc.entity;

public class Student {
	private int id;
	private String name;
	private String sex;
	private int  age;
	private String phone;
	public Student() {
		super();
	}
	
	public Student(String name, String sex, int age, String phone) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}

	public Student(int id, String name, String sex, int age, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone + "]";
	}
	
	

}
