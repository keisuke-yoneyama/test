package com.internousdev.webproj.action;

import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport {

	private String name;
	private String qtype;
	private String body;

	public String execute() {
		return SUCCESS;
	}

	public String getName() {
		return name;
	}// name�̃Q�b�^�[

	public void setName(String name) {
		this.name = name;
	}// name�̃Z�b�^�[,�₢���킹������name�ɃZ�b�g

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}// �Z�b�^�[�A�₢���킹�̃^�C�v��qtype�ɃZ�b�g

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;// �Z�b�^�[�A���₢���킹�̓��e(body)��body�ɃZ�b�g
	}

}
