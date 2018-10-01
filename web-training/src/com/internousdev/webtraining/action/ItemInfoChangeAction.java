package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.ItemInfoDAO;
import com.internousdev.webtraining.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoChangeAction extends ActionSupport implements SessionAware {
	private int itemId;
	private Map<String, Object> session;
	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {

		String result = ERROR;

		if (!(itemId == 0)) {
			session.put("itemId", itemId);
		}
		if(!session.containsKey("user_id")) {
			return result;
		}

		result = SUCCESS;

		if(deleteFlg == null) {
			itemInfoList = itemInfoDAO.getSingleItemInfo(itemId);
		} else if(deleteFlg.equals("1")) {
			delete();
			result = "admin";
		}


		return result;
	}


	public void delete() throws SQLException {
		int res = itemInfoDAO.itemDelete(session.get("itemId").hashCode());

		if(res > 0) {
			itemInfoList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}


	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return this.itemInfoList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
