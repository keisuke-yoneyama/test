package com.internousdev.webtraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.webtraining.dto.DestinationInfoDTO;
import com.internousdev.webtraining.util.DBConnector;
import com.internousdev.webtraining.util.DateUtil;

public class DestinationInfoDAO {

	private DateUtil dateUtil = new DateUtil();

	public void creaeDestination(String user_id, String family_name, String first_name,
			String family_name_kana, String first_name_kana,
			String email, String tel_number,
			String user_address) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into destination_info "
				+ "(user_id, family_name, first_name, family_name_kana, "
				+ "first_name_kana, email, tel_number, user_address, "
				+ "regist_date, update_date) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, family_name);
			preparedStatement.setString(3, first_name);
			preparedStatement.setString(4, family_name_kana);
			preparedStatement.setString(5, first_name_kana);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, tel_number);
			preparedStatement.setString(8, user_address);
			preparedStatement.setString(9, dateUtil.getDate());
			preparedStatement.setString(10, dateUtil.getDate());

			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public ArrayList<DestinationInfoDTO> getDestinationInfo(String user_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<DestinationInfoDTO> destinationInfoDTO = new ArrayList<DestinationInfoDTO>();
		String sql = "select * from destination_info where user_id = ? order by regist_date DESC";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					DestinationInfoDTO dto = new DestinationInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUser_id(resultSet.getString("user_id"));
					dto.setFamily_name(resultSet.getString("family_name"));
					dto.setFirst_name(resultSet.getString("first_name"));
					dto.setFamily_name_kana(resultSet.getString("family_name_kana"));
					dto.setFirst_name_kana(resultSet.getString("first_name_kana"));
					dto.setEmail(resultSet.getString("email"));
					dto.setTel_number(resultSet.getString("tel_number"));
					dto.setUser_address(resultSet.getString("user_address"));
					dto.setRegist_date(resultSet.getString("regist_date"));
					dto.setUpdate_date(resultSet.getString("update_date"));
					destinationInfoDTO.add(dto);
				}

			} else {
				destinationInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return destinationInfoDTO;
	}

	public void destinationDelete(String user_id, int id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from destination_info where user_id = ? and id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}


}
