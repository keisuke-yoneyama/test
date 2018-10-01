package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DestinationCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

	public String execute() throws SQLException {
		if(!session.containsKey("user_id")) {
			return ERROR;
		}

		if(!session.containsKey("checked")) {
			return ERROR;
		}

		destinationInfoDAO.creaeDestination
				(session.get("user_id").toString(),
				session.get("family_name_provisional").toString(), session.get("first_name_provisional").toString(),
				session.get("family_name_kana_provisional").toString(),session.get("first_name_kana_provisional").toString(),
				session.get("email_provisional").toString(),session.get("tel_number_provisional").toString(),
				session.get("user_address_provisional").toString());
		String result = SUCCESS;

		session.remove("checked");

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
