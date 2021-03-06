package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.CartInfoDAO;
import com.internousdev.webtraining.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryInfoAction extends ActionSupport implements SessionAware  {
	public Map<String, Object> session;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();
	private ArrayList<CartInfoDTO> cartInfoList = new ArrayList<CartInfoDTO>();
	private String deleteFlg;
	private String message;
	private int total_price;
	private List<Integer> checkList = new ArrayList<Integer>();

	public String execute() throws SQLException {
		if(!session.containsKey("user_id")) {
			return ERROR;
		}

		String user_id = session.get("user_id").toString();

		if(deleteFlg == null) {

		} else if(deleteFlg.equals("1") && checkList.isEmpty()) {
			setMessage("チェックされていません。");
		} else if(deleteFlg.equals("1")) {
			checkList.forEach(s -> {
				try {
					cartInfoDAO.cartItemDelete(user_id, s);
				} catch (Exception e) {
					e.printStackTrace();
				}
//				cartInfoDAO.cartItemDelete(user_id, s);
	        });
			setMessage("商品情報を正しく削除しました。");
		}

		cartInfoList = cartInfoDAO.getCartInfo(user_id);
		session.put("cartInfoList", cartInfoList);

		total_price = cartInfoDAO.getTotalPrice(user_id);
		session.put("total_price", total_price);

		return SUCCESS;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartInfoDTO> getCartInfoList() {
		return this.cartInfoList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotal_price() {
		return this.total_price;
	}

	public void setCheckList(List<Integer> checkList) {
		this.checkList = checkList;
	}

}
