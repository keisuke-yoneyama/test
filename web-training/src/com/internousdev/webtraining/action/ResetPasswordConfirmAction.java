package com.internousdev.webtraining.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.LoginDAO;
import com.internousdev.webtraining.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {
	private String user_id;
	private String password;
	private String newPassword;
	private String confirmPassword;
	private Map<String, Object> session;
	private String errorMassage;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();

	public String execute() {
		String result = SUCCESS;
		loginDTO = loginDAO.getLoginUserInfo(user_id, password);
		session.put("resetPasswordUser", loginDTO);

		if (((LoginDTO)session.get("resetPasswordUser")).getLoginFlg()) {

			if(!(user_id.equals(""))
					&& !(password.equals(""))
					&& !(newPassword.equals(""))
					&& !(confirmPassword.equals(""))) {
				if(!newPassword.equals(confirmPassword)) {
					setErrorMassage("新しいパスワードが一致しません。");
					result = ERROR;
					return result;
				}
				String p = "*";
				String concealPassword = "";
				for (int i = 0; i < newPassword.length(); i++) {
					concealPassword += p;
				}
				session.put("user_id_reset", user_id);
				session.put("newPassword_reset", newPassword);
				session.put("concealPassword", concealPassword);
			} else {
				setErrorMassage("未入力の項目があります。");
				result = ERROR;
			}
		} else {
			setErrorMassage("ログインIDまたはパスワードが違います。");
			result = ERROR;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
}
