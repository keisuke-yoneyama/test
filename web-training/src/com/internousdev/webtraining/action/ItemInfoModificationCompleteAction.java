package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.ItemInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoModificationCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();

	public String execute() throws SQLException {
		String result = ERROR;
		int error = itemInfoDAO.updateItem
				(session.get("itemId").hashCode(), session.get("product_name").toString(),
				session.get("product_name_kana").toString(), session.get("product_description").toString(),
				session.get("category_id").hashCode(), session.get("price").hashCode(),
				session.get("image_file_path").toString(), session.get("image_file_name").toString(),
				session.get("release_date").toString(), session.get("release_company").toString(), session.get("stock").hashCode());
		if(error == 0) {
			result = SUCCESS;
		}

		return result;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
