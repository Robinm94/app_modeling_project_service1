package com.example.asssignment.request;

public class FeeRequest {
	private String feeType;
	private double price;
	private int quantity;
	
	public FeeRequest() {
		super();
	}
	
	public FeeRequest(String feeType, double price, int quantity) {
		super();
		this.feeType = feeType;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
