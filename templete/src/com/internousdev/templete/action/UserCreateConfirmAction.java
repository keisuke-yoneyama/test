package com.internousdev.templete.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	/**
	 *
	 */
	private static final long serialVersionUID = -3209867462625751330L;
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;

	public String execute() {
		String result = SUCCESS;

		if (!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))) {
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
		} else {
			setErrorMessage("譛ｪ蜈･蜉帙�ｮ鬆�逶ｮ縺後≠繧翫∪縺�.");
			result = ERROR;
		}
		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
