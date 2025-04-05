package com.example.asssignment.request;

import java.util.Date;

public class AcctTransactionRequest {
    private String orderId;
    private String transactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private Date orderDateTime = new Date(System.currentTimeMillis());
    private double orderAmt;
    private double balanceAmt;
    
	public AcctTransactionRequest() {
		super();
	}
	
	public AcctTransactionRequest(String orderId, String transactionType, String tickerSymbol, double transactionPrice, double orderAmt, double balanceAmt) {
		super();
		this.orderId = orderId;
		this.transactionType = transactionType;
		this.tickerSymbol = tickerSymbol;
		this.transactionPrice = transactionPrice;
		this.orderDateTime = new Date(System.currentTimeMillis());
		this.orderAmt = orderAmt;
		this.balanceAmt = balanceAmt;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public double getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	public Date getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public double getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}
	public double getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
    
    
}
