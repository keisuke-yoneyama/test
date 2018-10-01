package com.internousdev.webtraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.webtraining.dto.UserInfoDTO;
import com.internousdev.webtraining.util.DBConnector;
import com.internousdev.webtraining.util.DateUtil;

public class UserInfoDAO {

	private DateUtil dateUtil = new DateUtil();


	public ArrayList<UserInfoDTO> getUserInfo() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		String sql = "select * from user_info";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setFamily_name(resultSet.getString("family_name"));
				dto.setFirst_name(resultSet.getString("first_name"));
				dto.setFamily_name_kana(resultSet.getString("family_name_kana"));
				dto.setFirst_name_kana(resultSet.getString("first_name_kana"));
				dto.setGender(resultSet.getInt("gender"));
				dto.setEmail(resultSet.getString("email"));
				dto.setUser_id(resultSet.getString("user_id"));
				dto.setPassword(resultSet.getString("password"));
				userInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userInfoDTO;
	}

	public int userAllDelete() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from user_info where id != 1";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;
	}


	public ArrayList<UserInfoDTO> getSingleUserInfo(int userId) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();
		String sql = "select * from user_info where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					UserInfoDTO dto = new UserInfoDTO();
					dto.setFamily_name(resultSet.getString("family_name"));
					dto.setFirst_name(resultSet.getString("first_name"));
					dto.setFamily_name_kana(resultSet.getString("family_name_kana"));
					dto.setFirst_name_kana(resultSet.getString("first_name_kana"));
					dto.setGender(resultSet.getInt("gender"));
					dto.setEmail(resultSet.getString("email"));
					dto.setUser_id(resultSet.getString("user_id"));
					dto.setPassword(resultSet.getString("password"));
					userInfoDTO.add(dto);
				}
			} else {
				userInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userInfoDTO;
	}

	public int userDelete(int userId) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from user_info where id = ? and id != 1";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;
	}

	public void createUser( String user_id_provisional,String password_provisional,
			String family_name_provisional, String first_name_provisional,
			String family_name_kana_provisional, String first_name_kana_provisional,
			int gender_provisional, String email_provisional) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into user_info "
				+ "(user_id, password, family_name, first_name, family_name_kana, first_name_kana, gender, email, regist_date, update_date) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id_provisional);
			preparedStatement.setString(2, password_provisional);
			preparedStatement.setString(3, family_name_provisional);
			preparedStatement.setString(4, first_name_provisional);
			preparedStatement.setString(5, family_name_kana_provisional);
			preparedStatement.setString(6, first_name_kana_provisional);
			preparedStatement.setInt(7, gender_provisional);
			preparedStatement.setString(8, email_provisional);
			preparedStatement.setString(9, dateUtil.getDate());
			preparedStatement.setString(10, dateUtil.getDate());

			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}


	public void updateUser(int id, String user_id_provisional,String password_provisional,
			String family_name_provisional, String first_name_provisional,
			String family_name_kana_provisional, String first_name_kana_provisional,
			int gender_provisional, String email_provisional) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update user_info set "
				+ "user_id = ?, password = ?, family_name = ?, "
				+ "first_name = ?, family_name_kana = ?, "
				+ "first_name_kana = ?, gender = ?, email = ?, "
				+ "update_date = ? where id= ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id_provisional);
			preparedStatement.setString(2, password_provisional);
			preparedStatement.setString(3, family_name_provisional);
			preparedStatement.setString(4, first_name_provisional);
			preparedStatement.setString(5, family_name_kana_provisional);
			preparedStatement.setString(6, first_name_kana_provisional);
			preparedStatement.setInt(7, gender_provisional);
			preparedStatement.setString(8, email_provisional);
			preparedStatement.setString(9, dateUtil.getDate());
			preparedStatement.setInt(10, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void resetPassword( String user_id_reset,String newPassword_reset) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "update user_info set "
				+ "password = ?, update_date = ? where user_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPassword_reset);
			preparedStatement.setString(2, dateUtil.getDate());
			preparedStatement.setString(3, user_id_reset);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}


	public boolean userIdCheck(String user_id) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		boolean hasUserId = true;

		String sql = "select * from user_info where user_id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				hasUserId = true;
			} else {
				hasUserId =false;
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return hasUserId;
	}
}
