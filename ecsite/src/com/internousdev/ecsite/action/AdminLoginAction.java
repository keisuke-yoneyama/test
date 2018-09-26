package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.AdminLoginDAO;
import com.internousdev.ecsite.dto.AdminLoginDTO;
import com.internousdev.ecsite.dto.BuyItemDTO;



public class AdminLoginAction extends ActionSupport implements SessionAware
{
	private String AdminUserId;
	private String AdminUserPassword;
	public Map<String,Object>session;
	private AdminLoginDAO adminLoginDAO = new AdminLoginDAO();
	private AdminLoginDTO adminLoginDTO = new AdminLoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;
		adminLoginDTO adminLoginDAO.getAdmin
	}
}
