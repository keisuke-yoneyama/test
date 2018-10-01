package com.internousdev.webtraining.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoAdministratorAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	public String execute() {
		if(session.containsKey("administrator")) {
			return SUCCESS;
		}
		return ERROR;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
