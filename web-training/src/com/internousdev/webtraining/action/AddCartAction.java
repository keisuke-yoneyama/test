package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.CartInfoDAO;
import com.internousdev.webtraining.dto.CartInfoDTO;
import com.internousdev.webtraining.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware  {
	public Map<String, Object> session;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();
	private ArrayList<CartInfoDTO> cartInfoList = new ArrayList<CartInfoDTO>();
	private int product_count;

	public String execute() throws SQLException {

		String user_id = null;
		String tempUserId = null;

		if(!session.containsKey("user_id") && !session.containsKey("tempUserId")) {
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}

		if(session.containsKey("user_id")) {
			user_id = session.get("user_id").toString();
		} else {
			user_id = session.get("tempUserId").toString();
			tempUserId = session.get("tempUserId").toString();
		}

		cartInfoDAO.addCartItem
			(user_id, tempUserId, session.get("id").hashCode(),
			product_count, session.get("price").hashCode());

		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartInfoDTO> getCartInfoList() {
		return this.cartInfoList;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}


}
