package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.LoginDTO;
import com.internousdev.webproj5.util.DBConnector;

public class LoginDAO {
	public String username;
	public String password;

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public List<LoginDTO> select(String username, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users  where user_name=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);//パラメターインデックス(格納された順番),指定されたパラメータ値をJAVAのSTRING値に格納
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();// クエリー結果によって生成されたResultSetオブジェクトを戻す

			while (rs.next()) {// 行が存在する場合はtrue,存在しないときfalse
				LoginDTO dto = new LoginDTO();
				dto.setUsername(rs.getString("user_name"));// ResultセットクラスのgetString
				dto.setPassword(rs.getString("password"));// 同上、現在行にあたる列の値をstring値で取得
				loginDTOList.add(dto);
			}
			if (loginDTOList.size() <= 0) {
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当なし");//ログイン情報がなくてloginDTOListが空の場合
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginDTOList;
	}
}
