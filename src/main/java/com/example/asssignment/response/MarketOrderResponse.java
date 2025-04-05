
package com.example.asssignment.response;

import java.util.Date;

public class MarketOrderResponse {
    private String marketOrderId;
    private String orderId;
    private String transactionId;
    private String feeId;
    private double bid;
    private double ask;
    private String typeOfExchange;
    private String status;
    private Date orderDateTime;
    
	public MarketOrderResponse() {
		super();
	}

    public MarketOrderResponse(String marketOrderId, String orderId, String transactionId, String feeId, double bid, double ask, String typeOfExchange, String status, Date orderDateTime) {
        this.marketOrderId = marketOrderId;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.feeId = feeId;
        this.bid = bid;
        this.ask = ask;
        this.typeOfExchange = typeOfExchange;
        this.status = status;
        this.orderDateTime = orderDateTime;
    }

    public String getMarketOrderId() {
        return marketOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFeeId() {
        return feeId;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public String getTypeOfExchange() {
        return typeOfExchange;
    }

    public String getStatus() {
        return status;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setMarketOrderId(String marketOrderId) {
		this.marketOrderId = marketOrderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public void setTypeOfExchange(String typeOfExchange) {
		this.typeOfExchange = typeOfExchange;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	@Override
    public String toString() {
        return "MarketOrderResponse [marketOrderId=" + marketOrderId + ", orderId=" + orderId + ", transactionId=" + transactionId + ", feeId=" + feeId + ", bid=" + bid + ", ask=" + ask + ", typeOfExchange=" + typeOfExchange + ", status=" + status + ", orderDateTime=" + orderDateTime + "]";
    }
}
