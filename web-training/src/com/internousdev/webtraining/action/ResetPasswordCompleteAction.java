package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {

	private String user_id_reset;
	private String newPassword_reset;
	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public String execute() throws SQLException {
		if(!session.containsKey("user_id_reset")) {
			return ERROR;
		}
		userInfoDAO.resetPassword(session.get("user_id_reset").toString(), session.get("newPassword_reset").toString());
		String result = SUCCESS;

		return result;
	}

	public String getUser_id_reset() {
		return user_id_reset;
	}

	public void setUser_id_reset(String user_id_reset) {
		this.user_id_reset = user_id_reset;
	}

	public String getNewPassword_reset() {
		return newPassword_reset;
	}

	public void setNewPassword_reset(String newPassword_reset) {
		this.newPassword_reset = newPassword_reset;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
