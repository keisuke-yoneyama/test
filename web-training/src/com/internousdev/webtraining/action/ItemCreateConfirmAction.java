package com.internousdev.webtraining.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {

	private int id;
	private String product_name;
	private String product_name_kana;
	private String product_description;
	private int category_id;
	private int price;
	private String imageFilePath;
	private String release_date;
	private String release_company;
	private int status;
	private String regist_date;
	private String update_date;
	private Map<String, Object> session;
	private String errorMassage;
	private String productIdCheckError;
	private String imageFilePathError;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	public String execute() throws SQLException {
		String result = SUCCESS;

		if(userImage != null){
			setImageFilePathError(null);
		}else{
			setImageFilePathError("画像ファイルを選んでください");
		}

		if(!(product_name.equals(""))
			&& !(product_name_kana.equals(""))
			&& !(product_description.equals(""))
			&& !(category_id == 0)
			&& !(price == 0)
			&& !(release_date.equals(""))
			&& !(release_company.equals(""))) {
			session.put("product_name", product_name);
			session.put("product_name_kana", product_name_kana);
			session.put("product_description", product_description);
			session.put("category_id", category_id);
			session.put("price", price);
			session.put("release_date", release_date);
			session.put("release_company", release_company);
		} else {
			setErrorMassage("未入力の項目があります。");
			result = ERROR;
		}

		if (result == SUCCESS) {
			//選択した画像ファイルをサーバーに保存する
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");

			//ファイル名を乱数にする
			CommonUtility commonUtility = new CommonUtility();
			userImageFileName = commonUtility.getRamdomValue() + userImageFileName;

			//サーバー上に保存した画像をimageフォルダにコピーする
			File fileToCreate = new File(filePath,userImageFileName);
			try{
				FileUtils.copyFile(userImage, fileToCreate);
				session.put("image_file_name", userImageFileName);
				session.put("image_file_path", "./images/");
			}catch(IOException e){
				e.printStackTrace();
			}
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

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public String getProductIdCheckError() {
		return productIdCheckError;
	}

	public void setProductIdCheckError(String productIdCheckError) {
		this.productIdCheckError = productIdCheckError;
	}

	public String getImageFilePathError() {
		return imageFilePathError;
	}

	public void setImageFilePathError(String imageFilePathError) {
		this.imageFilePathError = imageFilePathError;
	}
}
