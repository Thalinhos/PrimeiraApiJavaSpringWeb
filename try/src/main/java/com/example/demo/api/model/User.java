package com.example.demo.api.model;

public class User {
	private int id;
	private String name;
	private int age;

	private static int idCounter = 0;
	
	public User( String name, int age) {
		this.id = ++idCounter;
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
