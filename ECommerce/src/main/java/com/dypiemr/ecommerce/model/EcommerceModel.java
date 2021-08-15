package com.dypiemr.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ecommerce")
public class EcommerceModel {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private long id;
	@Column(name="productName")
	private String productName;

	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="price")
	private String price;
	
	@Column(name="type")
	private String type;
	// define constructors
	
	public EcommerceModel() {
		
	}

	
	public EcommerceModel(String productName, String description, String quantity, String price, String type) {
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
	}

	// define getter/setter

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "EcommerceModel [id=" + id + ", productName=" + productName + ", description=" + description
				+ ", quantity=" + quantity + ", price=" + price + ", type=" + type + "]";
	}
	
	
		
}

