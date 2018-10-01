package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.CartInfoDAO;
import com.internousdev.webtraining.dao.DestinationInfoDAO;
import com.internousdev.webtraining.dao.LoginDAO;
import com.internousdev.webtraining.dto.DestinationInfoDTO;
import com.internousdev.webtraining.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String user_id;
	private String password;
	private boolean idSaved = false;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private String errorMassage;

	private DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
	private ArrayList<DestinationInfoDTO> destinationInfoList = new ArrayList<DestinationInfoDTO>();

	public String execute() throws SQLException {
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(user_id, password);
		session.put("loginUser", loginDTO);

		if (((LoginDTO)session.get("loginUser")).getLoginFlg()) {

			session.put("user_int_id", loginDTO.getId());
			session.put("id", loginDTO.getUser_id());
			session.put("user_id", loginDTO.getUser_id());
			session.put("family_name", loginDTO.getFamily_name());
			session.put("first_name", loginDTO.getFirst_name());

			result = SUCCESS;

			if (loginDTO.getAdministrator() == 1) {
				session.put("administrator", loginDTO.getAdministrator());
				session.put("administratorFamily_name", loginDTO.getFamily_name());
				session.put("administratorFirst_name", loginDTO.getFamily_name());
				result = "administrator";
			}

			if (idSaved) {
				session.put("idSaved", idSaved);
			} else {
				session.remove("idSaved");
			}

			if(session.containsKey("tempUserId")){
				int count = 0;
				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				count = cartInfoDAO.linkToLoginId(session.get("tempUserId").toString(), user_id);

				if(count > 0 && session.containsKey("settlementFlg")) {
					destinationInfoList = destinationInfoDAO.getDestinationInfo(user_id);
					session.put("destinationInfoList", destinationInfoList);

					result = "settlement";
				}
			}
			return result;
		} else {
			setErrorMassage("ログインIDまたはパスワードが違います。");
		}
		return result;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIdSaved(boolean idSaved) {
		this.idSaved = idSaved;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

	public ArrayList<DestinationInfoDTO> getDestinationInfoList() {
		return this.destinationInfoList;
	}

}
