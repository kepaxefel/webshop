package com.shop.domains;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
   	@Column(name = "ID")
	@Access(value=AccessType.FIELD)
	private int id;
	
	@Column(name = "ProductsName")
	private String productsName;
	
	@Column(name = "ProductsPart")
	private String productsPart;
	
	@Column(name = "Cost")
	private String cost;
	
	@Column(name = "UserId")
	private int userId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "UserId", insertable = false, updatable = false)
	private User user;
	
	@Column(name="CurrentDate")
	private String currentDate;
	
    public Order(String productsName, String productsPart, String cost, int id){
		this.productsName = productsName;
		this.productsPart = productsPart;
		this.cost = cost;
		this.userId = id;	
		Calendar currentDateTime = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		currentDate = sdf.format(currentDateTime.getTime());
	}
	
	public Order(){
		
	}
	
	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public String getProductsPart() {
		return productsPart;
	}

	public void setProductsPart(String productsPart) {
		this.productsPart = productsPart;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}	

	public String getCurrentDate() {
		return currentDate;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
