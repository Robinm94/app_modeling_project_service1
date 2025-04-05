package com.example.asssignment.response;

import java.util.Date;

public class AcctTransactionResponse {
	private String transactionId;
    private String orderId;
    private String transactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private Date orderDateTime;
    private double orderAmt;
    private double balanceAmt;
    
        public AcctTransactionResponse() {
        	        super();
        }
    
	public AcctTransactionResponse(String transactionId, String orderId, String transactionType, String tickerSymbol,
			double transactionPrice, Date orderDateTime, double orderAmt, double balanceAmt) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.transactionType = transactionType;
		this.tickerSymbol = tickerSymbol;
		this.transactionPrice = transactionPrice;
		this.orderDateTime = orderDateTime;
		this.orderAmt = orderAmt;
		this.balanceAmt = balanceAmt;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public String getOrderId() {
		return orderId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public double getTransactionPrice() {
		return transactionPrice;
	}
	public Date getOrderDateTime() {
		return orderDateTime;
	}
	public double getOrderAmt() {
		return orderAmt;
	}
	public double getBalanceAmt() {
		return balanceAmt;
	}
	
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}

	public void setBalanceAmt(double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	@Override
	public String toString() {
		return "AcctTransactionResponse [transactionId=" + transactionId + ", orderId=" + orderId + ", transactionType="
				+ transactionType + ", tickerSymbol=" + tickerSymbol + ", transactionPrice=" + transactionPrice
				+ ", orderDateTime=" + orderDateTime + ", orderAmt=" + orderAmt + ", balanceAmt=" + balanceAmt + "]";
	}
    
    
}
