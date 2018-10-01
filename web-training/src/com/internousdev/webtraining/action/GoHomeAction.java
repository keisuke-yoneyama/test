package com.internousdev.webtraining.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware  {

	public Map<String, Object> session;

	public String execute() {

		if(!session.containsKey("user_id") && !session.containsKey("tempUserId")) {
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
