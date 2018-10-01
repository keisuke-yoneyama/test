package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.ItemInfoDAO;
import com.internousdev.webtraining.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemInfoModificationConfirmAction extends ActionSupport implements SessionAware {


	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();


	private int id;
	private String product_name;
	private String product_name_kana;
	private String product_description;
	private int category_id;
	private int price;
	private int stock;
	private String image_file_path;
	private String image_file_name;
	private String release_date;
	private String release_company;
	private int status;
	private String regist_date;
	private String update_date;
	private Map<String, Object> session;
	private String errorMassage;

	public String execute() throws SQLException {
		String result = SUCCESS;

		if(!(product_name.equals(""))
			&& !(product_name_kana.equals(""))
			&& !(product_description.equals(""))
			&& !(category_id == 0)
			&& !(price == 0)
			&& !(stock == 0)
			&& !(image_file_path.equals(""))
			&& !(image_file_name.equals(""))
			&& !(release_date.equals(""))
			&& !(release_company.equals(""))) {
			session.put("product_name", product_name);
			session.put("product_name_kana", product_name_kana);
			session.put("product_description", product_description);
			session.put("category_id", category_id);
			session.put("price", price);
			session.put("stock", stock);
			session.put("image_file_path", image_file_path);
			session.put("image_file_name", image_file_name);
			session.put("release_date", release_date);
			session.put("release_company", release_company);
		} else {
			setErrorMassage("未入力の項目があります。");
			int itemId = session.get("itemId").hashCode();
			itemInfoList = itemInfoDAO.getSingleItemInfo(itemId);
			result = ERROR;
		}
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_name_kana() {
		return product_name_kana;
	}

	public void setProduct_name_kana(String product_name_kana) {
		this.product_name_kana = product_name_kana;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage_file_path() {
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path) {
		this.image_file_path = image_file_path;
	}

	public String getImage_file_name() {
		return image_file_name;
	}

	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getRelease_company() {
		return release_company;
	}

	public void setRelease_company(String release_company) {
		this.release_company = release_company;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return this.itemInfoList;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
