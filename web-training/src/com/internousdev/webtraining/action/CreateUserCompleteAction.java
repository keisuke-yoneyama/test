package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware {

	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;
	private int gender;
	private String email;
	private String user_id;
	private String password;
	private Map<String, Object> session;

	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public String execute() throws SQLException {

		userInfoDAO.createUser
				(user_id, password,
				family_name, first_name,
				family_name_kana,first_name_kana,
				gender, email);

		session.put("id", user_id);
		session.put("user_id", user_id);
		session.put("family_name", family_name);
		session.put("first_name", first_name);

		return SUCCESS;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	public void setFirst_name_kana(String first_name_kana) {
		this.first_name_kana = first_name_kana;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
