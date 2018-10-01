package com.internousdev.webtraining.action;

import java.sql.SQLException;

import com.internousdev.webtraining.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport {
	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;
	private int gender;
	private String email;
	private String user_id;
	private String password;
	private String errorMassage;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public String execute() throws SQLException {
		String result = SUCCESS;

		if(!(family_name.equals(""))
			&& !(first_name.equals(""))
			&& !(family_name_kana.equals(""))
			&& !(first_name_kana.equals(""))
			&& !(email.equals(""))
			&& !(user_id.equals(""))
			&& !(password.equals(""))) {
			if(userInfoDAO.userIdCheck(user_id)) {
				setErrorMassage("このログインIDはすでに使用されています。");
				result = ERROR;
			} else {
				result = SUCCESS;
			}
		} else {
			setErrorMassage("未入力の項目があります。");
			result = ERROR;
		}

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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}
