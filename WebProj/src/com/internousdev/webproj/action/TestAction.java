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
	}// ���[�U�����Ăяo�����ƂɕԂ�

	public void setUsername(String username) {
		this.username = username;
	}// ���[�U����ϐ��ɃZ�b�g

	public String getPassword() {
		return password;
	}// �p�X���[�h���Ăяo�����ƂɕԂ�

	public void setPassword(String password) {
		this.password = password;
	}// �p�X���[�h��ϐ��ɃZ�b�g
}
