package com.zjy.bean;

import java.io.*;

public class Customer implements Serializable {

	private Integer id;

	private String username;

	private String password;

	public Customer() {
	}

	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}