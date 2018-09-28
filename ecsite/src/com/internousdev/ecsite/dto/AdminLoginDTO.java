package com.internousdev.ecsite.dto;

public class AdminLoginDTO {
	private boolean loginFlg = false;

	private String login_id;

	private String login_pass;

	private String user_name;

	public String getAdminLoginId() {
		return login_id;
	}

	public void setAdminLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getAdminLoginPassword() {
		return login_pass;
	}

	public void setAdminLoginPassword(String login_pass) {
		this.login_pass = login_pass;
	}

	public String getAdminUserName() {
		return user_name;
	}

	public void setAdminUserName(String user_name) {
		this.user_name = user_name;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
}
