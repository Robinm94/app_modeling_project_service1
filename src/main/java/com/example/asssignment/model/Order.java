package com.example.asssignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Order {
	@Id
	private String orderId;
	private String userId;
	private String stockId;
	private int quantity;
	private double price;
	
	public Order() {
		super();
	}
	
	public Order(String userId, String stockId, int quantity, double price) {
		super();
		this.userId = userId;
		this.stockId = stockId;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order(String orderId, String userId, String stockId, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.stockId = stockId;
		this.quantity = quantity;
		this.price = price;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
