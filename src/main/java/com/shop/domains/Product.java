package com.shop.domains;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tomcat.util.codec.binary.Base64;


@Entity
@Table(name="products")
public class Product {
	
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
	
	@Column(name = "Image")
	private byte[] image;
	
	public Product(){
		
	}
	
	public Product(String productsName, String productsPart, String cost, int id) {		
		this.productsName = productsName;
		this.productsPart = productsPart;
		this.cost = cost;		
		this.id = id;			
	}
	
	public Product(String productsName, String productsPart, String cost) {		
		this.productsName = productsName;
		this.productsPart = productsPart;
		this.cost = cost;		
	}

	public Product(String productsName, String cost) {
		this.productsName = productsName;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getByteArrayString(){
	  	return Base64.encodeBase64String(getImage());
	}
}
