package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.UserInfoDAO;
import com.internousdev.webtraining.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoModificationConfirmAction extends ActionSupport implements SessionAware {

	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private ArrayList<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();

	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;
	private int gender;
	private String email;
	private String user_id;
	private String password;
	private Map<String, Object> session;
	private String errorMassage;

	public String execute() throws SQLException {
		String result = SUCCESS;

		if(!(family_name.equals(""))
			&& !(first_name.equals(""))
			&& !(family_name_kana.equals(""))
			&& !(first_name_kana.equals(""))
			&& !(email.equals(""))
			&& !(user_id.equals(""))
			&& !(password.equals(""))) {
			session.put("family_name_provisional", family_name);
			session.put("first_name_provisional", first_name);
			session.put("family_name_kana_provisional", family_name_kana);
			session.put("first_name_kana_provisional", first_name_kana);
			session.put("gender_provisional", gender);
			session.put("email_provisional", email);
			session.put("user_id_provisional", user_id);
			session.put("password_provisional", password);
		} else {
			setErrorMassage("未入力の項目があります。");
			int userId = session.get("userId").hashCode();
			userInfoList = userInfoDAO.getSingleUserInfo(userId);
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<UserInfoDTO> getUserInfoList() {
		return this.userInfoList;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}
