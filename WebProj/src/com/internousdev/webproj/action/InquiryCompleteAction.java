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
	}// nameのゲッター

	public void setName(String name) {
		this.name = name;
	}// nameのセッター,問い合わせ氏名をnameにセット

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}// セッター、問い合わせのタイプをqtypeにセット

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;// セッター、お問い合わせの内容(body)をbodyにセット
	}

}
