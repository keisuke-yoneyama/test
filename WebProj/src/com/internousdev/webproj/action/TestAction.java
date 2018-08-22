package com.internousdev.webproj.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}// ユーザ名を呼び出しもとに返す

	public void setUsername(String username) {
		this.username = username;
	}// ユーザ名を変数にセット

	public String getPassword() {
		return password;
	}// パスワードを呼び出しもとに返す

	public void setPassword(String password) {
		this.password = password;
	}// パスワードを変数にセット
}
