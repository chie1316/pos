package com.ramirez.pos.entity;

public class User {

	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
