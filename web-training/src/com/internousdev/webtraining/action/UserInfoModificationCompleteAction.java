package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoModificationCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public String execute() throws SQLException {
		if(!session.containsKey("userId")) {
			return ERROR;
		}
		userInfoDAO.updateUser
				(session.get("userId").hashCode(), session.get("user_id_provisional").toString(), session.get("password_provisional").toString(),
				session.get("family_name_provisional").toString(), session.get("first_name_provisional").toString(),
				session.get("family_name_kana_provisional").toString(),session.get("first_name_kana_provisional").toString(),
				session.get("gender_provisional").hashCode(), session.get("email_provisional").toString());
		String result = SUCCESS;

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
