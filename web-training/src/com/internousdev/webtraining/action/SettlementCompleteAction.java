package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.CartInfoDAO;
import com.internousdev.webtraining.dao.ItemInfoDAO;
import com.internousdev.webtraining.dao.PurchaseHistoryInfoDAO;
import com.internousdev.webtraining.dto.CartInfoDTO;
import com.internousdev.webtraining.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int selectAddress;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
	private ArrayList<CartInfoDTO> cartInfoList = new ArrayList<CartInfoDTO>();
	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	private ItemInfoDAO itemDAO = new ItemInfoDAO();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	private boolean check = true;
	private String message = "";

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		if(!session.containsKey("cartInfoList")) {
			return ERROR;
		}

		cartInfoList = (ArrayList<CartInfoDTO>)session.get("cartInfoList");


		cartInfoList.forEach(s -> {
			try {
				itemInfoList = itemInfoDAO.getSingleItemInfo(s.getProduct_id());
				int buySum = cartInfoDAO.cartSameItemSum(s.getProduct_id(), s.getUser_id());
				if(itemInfoList.get(0).getStock() - buySum < 0) {
					message += s.getProduct_name() + " ";
					check = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		if (check) {
			cartInfoList.forEach(s -> {
				try {
					itemInfoList = itemDAO.getSingleItemInfo(s.getProduct_id());
					itemInfoDAO.updateItemStock(s.getProduct_id(), itemInfoList.get(0).getStock() - s.getProduct_count());
					purchaseHistoryInfoDAO.addPurchaseHistoryInfo
					(s.getUser_id(), s.getProduct_id(), s.getProduct_count(),
					s.getPrice(), selectAddress);
					cartInfoDAO.cartItemDelete(s.getUser_id(), s.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		if(!check) {
			return ERROR;
		}

		String result = SUCCESS;

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setSelectAddress(int selectAddress) {
		this.selectAddress = selectAddress;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
