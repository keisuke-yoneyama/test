package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.UserInfoDAO;
import com.internousdev.webtraining.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoModificationAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private ArrayList<UserInfoDTO> userInfoList = new ArrayList<UserInfoDTO>();

	public String execute() throws SQLException {
		if(!session.containsKey("id") && !session.containsKey("userId")) {
			return ERROR;
		}
		int userId = session.get("userId").hashCode();
		userInfoList = userInfoDAO.getSingleUserInfo(userId);

		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<UserInfoDTO> getUserInfoList() {
		return this.userInfoList;
	}

}
