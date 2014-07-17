package com.zjy.form;

import org.apache.struts.action.ActionForm;

public class UpdateForm extends ActionForm{
	private int id;//该属性用来保存分页的编号
	private String username;//该属性用来保存用户名
	private String password;//该属性用来保存密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
