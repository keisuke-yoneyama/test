package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
//	private int id;
	private String item_name;
	private String item_price;
	private String item_stock;
	public Map<String, Object> session;
	public String errorMassage;

	public String execute(){
		String result = SUCCESS;
		if(!(item_name.equals(""))&& !(item_price.equals(""))&& !(item_stock.equals(""))){
			session.put("item_name", item_name);
			session.put("item_price", item_price);
			session.put("item_stock", item_stock);
		}else{
			setErrorMassage("未入力の情報があります。");
			result=ERROR;
		}
		return result;
	}
	public String getItem_name(){
		return item_name;
	}
	public void setItem_name(String item_name){
		this.item_name=item_name;
	}
	public String getItem_price(){
		return item_price;
	}
	public void setItem_price(String item_price){
		this.item_price=item_price;
	}
	public String getItem_stock(){
		return item_stock;
	}
	public void setItem_stock(String item_stock){
		this.item_stock = item_stock;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public String getErrorMassage(){
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage){
		this.errorMassage = errorMassage;
	}
}
