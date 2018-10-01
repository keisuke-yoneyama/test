package com.internousdev.webtraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.webtraining.dto.CartInfoDTO;
import com.internousdev.webtraining.util.DBConnector;
import com.internousdev.webtraining.util.DateUtil;

public class CartInfoDAO {

	private DateUtil dateUtil = new DateUtil();

	public void addCartItem(String user_id,String tempUserId, int product_id,
			int product_count, int price) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "insert into cart_info "
				+ "(user_id, temp_user_id, product_id, product_count, price, regist_date, update_date) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			preparedStatement.setString(2, tempUserId);
			preparedStatement.setInt(3, product_id);
			preparedStatement.setInt(4, product_count);
			preparedStatement.setInt(5, price);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.setString(7, dateUtil.getDate());

			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public ArrayList<CartInfoDTO> getCartInfo(String user_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
		String sql = "select * from cart_info ci left join product_info pi on ci.product_id = pi.id where user_id = ? order by ci.regist_date DESC";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					CartInfoDTO dto = new CartInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUser_id(resultSet.getString("user_id"));
					dto.setProduct_id(resultSet.getInt("product_id"));
					dto.setProduct_count(resultSet.getInt("product_count"));
					dto.setPrice(resultSet.getInt("price"));;
					dto.setStock(resultSet.getInt("stock"));
					dto.setRegist_date(resultSet.getString("regist_date"));
					dto.setUpdate_date(resultSet.getString("update_date"));
					dto.setSubtotal(resultSet.getInt("price") * resultSet.getInt("product_count"));
					dto.setProduct_name(resultSet.getString("product_name"));
					dto.setProduct_name_kana(resultSet.getString("product_name_kana"));
					dto.setProduct_description(resultSet.getString("product_description"));
					dto.setImage_file_path(resultSet.getString("image_file_path"));
					dto.setImage_file_name(resultSet.getString("image_file_name"));
					dto.setRelease_company(resultSet.getString("release_company"));
					dto.setRelease_date(resultSet.getString("release_date"));
					cartInfoDTO.add(dto);
				}

			} else {
				cartInfoDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return cartInfoDTO;
	}

	public int getTotalPrice(String user_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int total_price = 0;
		String sql = "select * from cart_info where user_id = ?";
//		String sql = "select * from cart_info ci left join product_info pi on ci.product_id = pi.product_id where user_id = ? order by ci.regist_date DESC";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				total_price += resultSet.getInt("price") * resultSet.getInt("product_count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return total_price;
	}

	public void cartItemDelete(String user_id, int id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from cart_info where user_id = ? and id = ?";
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

	public int cartSameItemSum(int product_id, String user_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int sum = 0;

		String sql = "select sum(product_count) from cart_info where product_id = ? and user_id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product_id);
			preparedStatement.setString(2, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				sum += resultSet.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return sum;
	}


	public int linkToLoginId(String tempUserId, String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "update cart_info set user_id=?, temp_user_id = null where temp_user_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, tempUserId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
