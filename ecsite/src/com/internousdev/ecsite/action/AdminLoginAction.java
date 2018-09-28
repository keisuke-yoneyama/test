package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AdminLoginDAO;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.AdminLoginDTO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements SessionAware {
	private String adminUserId;
	private String adminUserPassword;
	public Map<String, Object> session;
	private AdminLoginDAO adminLoginDAO = new AdminLoginDAO();
	private AdminLoginDTO adminLoginDTO = new AdminLoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() {
		String result = ERROR;
		adminLoginDTO = adminLoginDAO.getAdminLoginUserInfo(adminUserId, adminUserPassword);
		session.put("adminUser", adminLoginDTO);

		if (((AdminLoginDTO) session.get("adminUser")).getLoginFlg()) {
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", adminLoginDTO.getAdminLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			System.out.println(adminLoginDTO.getAdminLoginId());
			System.out.println(buyItemDTO.getId());
			System.out.println(buyItemDTO.getItemName());
			System.out.println(buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getAdminUserPassword() {
		return adminUserPassword;
	}

	public void setAdminUserPassword(String adminUserPassword) {
		this.adminUserPassword = adminUserPassword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
