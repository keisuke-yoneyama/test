package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.PurchaseHistoryInfoDAO;
import com.internousdev.webtraining.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoPurchaseHistoryInfoAction extends ActionSupport implements SessionAware  {
	public Map<String, Object> session;
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
	private ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoInfoList = new ArrayList<PurchaseHistoryInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if(!session.containsKey("user_id")) {
			return ERROR;
		}

		String user_id = session.get("user_id").toString();

		if(deleteFlg == null) {

		} else if(deleteFlg.equals("1")) {
			setMessage("商品情報を正しく削除しました。");
			purchaseHistoryInfoDAO.purchaseHistoryDelete(user_id);
		}

		purchaseHistoryInfoInfoList = purchaseHistoryInfoDAO.getPurchaseHistoryInfo(user_id);
		session.put("purchaseHistoryInfoInfoList", purchaseHistoryInfoInfoList);


		return SUCCESS;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoInfoList() {
		return this.purchaseHistoryInfoInfoList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
