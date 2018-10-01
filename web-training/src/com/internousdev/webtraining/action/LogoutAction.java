package com.internousdev.webtraining.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	public String execute() {
		if(session.containsKey("id")) {
			String id = session.get("id").toString();
			boolean idSaved = false;
			if(session.containsKey("idSaved")) {
				idSaved = session.get("idSaved").equals(true);
			}
			session.clear();
			session.put("id", id);
			session.put("idSaved", idSaved);
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
