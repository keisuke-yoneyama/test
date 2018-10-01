package com.internousdev.webtraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.webtraining.dto.PurchaseHistoryInfoDTO;
import com.internousdev.webtraining.util.DBConnector;
import com.internousdev.webtraining.util.DateUtil;

public class PurchaseHistoryInfoDAO {

	private DateUtil dateUtil = new DateUtil();

	public void addPurchaseHistoryInfo(String user_id, int product_id,
			int product_count, int price, int destination_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into purchase_history_info "
				+ "(user_id, product_id, product_count, price, destination_id, regist_date, update_date) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setInt(2, product_id);
			preparedStatement.setInt(3, product_count);
			preparedStatement.setInt(4, price);
			preparedStatement.setInt(5, destination_id);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.setString(7, dateUtil.getDate());

			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public ArrayList<PurchaseHistoryInfoDTO> getPurchaseHistoryInfo(String user_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTO = new ArrayList<PurchaseHistoryInfoDTO>();
		String sql = "select * from purchase_history_info phi left join product_info pi on phi.product_id = pi.id where user_id = ? order by phi.regist_date DESC";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUser_id(resultSet.getString("user_id"));
					dto.setProduct_id(resultSet.getInt("product_id"));
					dto.setProduct_count(resultSet.getInt("product_count"));
					dto.setPrice(resultSet.getInt("price"));
					dto.setDestination_id(resultSet.getInt("destination_id"));
					dto.setStock(resultSet.getInt("stock"));
					dto.setRegist_date(resultSet.getString("regist_date"));
					dto.setUpdate_date(resultSet.getString("update_date"));
					dto.setProduct_name(resultSet.getString("product_name"));
					dto.setProduct_name_kana(resultSet.getString("product_name_kana"));
					dto.setImage_file_path(resultSet.getString("image_file_path"));
					dto.setImage_file_name(resultSet.getString("image_file_name"));
					dto.setRelease_date(resultSet.getDate("release_date"));
					dto.setRelease_company(resultSet.getString("release_company"));
					purchaseHistoryInfoDTO.add(dto);
				}

			} else {
				purchaseHistoryInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return purchaseHistoryInfoDTO;
	}

	public void purchaseHistoryDelete(String user_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from purchase_history_info where user_id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}


}
