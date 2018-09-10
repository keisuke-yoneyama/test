package com.internousdev.templete.dto;

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFig = false;

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setLoginFig(boolean loginFig) {
		this.loginFig = loginFig;
	}

	public boolean getLoginFig() {
		return loginFig;
	}
}
