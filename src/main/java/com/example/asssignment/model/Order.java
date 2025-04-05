package com.example.asssignment.model;


import java.util.Date;

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
	private String tickerSymbol;
	private int quantity;
	private double price;
	private String orderType;
	private Date orderDate = new Date(System.currentTimeMillis());
	private String status = "CREATED";


	public Order() {
		super();
	}
	
	public Order(String userId, String tickerSymbol, int quantity, double price, String orderType) {
		super();
		this.userId = userId;
		this.tickerSymbol = tickerSymbol;
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
		this.orderDate = new Date(System.currentTimeMillis());
	}
	
	public Order(String orderId, String userId, String tickerSymbol, int quantity, double price, String orderType, Date orderDate, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.tickerSymbol = tickerSymbol;
		this.quantity = quantity;
		this.price = price;
		this.orderType = orderType;
		this.orderDate = orderDate;
		this.status = status;
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

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
