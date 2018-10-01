package com.internousdev.webtraining.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DestinationConfirmAction extends ActionSupport implements SessionAware {
	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;
	private String email;
	private String user_id;
	private String tel_number;
	private String user_address;
	private Map<String, Object> session;
	private String errorMassage;

	public String execute() {
		String result = SUCCESS;

		if(!(family_name.equals(""))
			&& !(first_name.equals(""))
			&& !(family_name_kana.equals(""))
			&& !(first_name_kana.equals(""))
			&& !(email.equals(""))
			&& !(tel_number.equals(""))
			&& !(user_address.equals(""))) {
			session.put("family_name_provisional", family_name);
			session.put("first_name_provisional", first_name);
			session.put("family_name_kana_provisional", family_name_kana);
			session.put("first_name_kana_provisional", first_name_kana);
			session.put("email_provisional", email);
			session.put("user_id_provisional_provisional", user_id);
			session.put("tel_number_provisional", tel_number);
			session.put("user_address_provisional", user_address);
		} else {
			setErrorMassage("未入力の項目があります。");
			result = ERROR;
		}

		session.put("checked", 1);

		return result;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFamily_name_kana() {
		return family_name_kana;
	}

	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	public String getFirst_name_kana() {
		return first_name_kana;
	}

	public void setFirst_name_kana(String first_name_kana) {
		this.first_name_kana = first_name_kana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTel_number() {
		return tel_number;
	}

	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}
