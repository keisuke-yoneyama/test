package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.DestinationInfoDAO;
import com.internousdev.webtraining.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware  {
	private int selectAddress;
	public Map<String, Object> session;
	private DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
	private ArrayList<DestinationInfoDTO> destinationInfoList = new ArrayList<DestinationInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if(!session.containsKey("user_id")) {
			session.put("settlementFlg", 1);
			return ERROR;
		}

		String user_id = session.get("user_id").toString();

		if(deleteFlg == null) {

		} else if(deleteFlg.equals("1")) {
			destinationInfoDAO.destinationDelete(session.get("user_id").toString(), selectAddress);
			setMessage("商品情報を正しく削除しました。");
		}

		destinationInfoList = destinationInfoDAO.getDestinationInfo(user_id);
		session.put("destinationInfoList", destinationInfoList);

		return SUCCESS;
	}

	public void setSelectAddress(int selectAddress) {
		this.selectAddress = selectAddress;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<DestinationInfoDTO> getDestinationInfoList() {
		return this.destinationInfoList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
