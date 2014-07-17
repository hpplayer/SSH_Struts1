package com.zjy.form;

import org.apache.struts.action.ActionForm;

public class InsertForm extends ActionForm{
	private String username;//该属性用来保存用户名
	private String password;//该属性用来保存密码
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
