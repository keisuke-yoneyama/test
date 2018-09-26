package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.AdminLoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AdminLoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private AdminLoginDTO adminLoginDTO = new AdminLoginDTO();

	public AdminLoginDTO getAdminLoginUserInfo(String adminLoginUserId,String adminLoginPassword){
		String sql = "SELECT * FROM admin_user_transaction where login_id = ? AND login_pass = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, adminLoginUserId);
			preparedStatement.setString(2, adminLoginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				adminLoginDTO.set//ここから始める。AdminLoginDTOでセッターゲッターを定義するところから
			}
		}
	}
}
