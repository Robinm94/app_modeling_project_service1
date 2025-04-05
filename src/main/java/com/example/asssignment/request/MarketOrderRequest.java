
package com.example.asssignment.request;

public class MarketOrderRequest {
    private String orderId;
    private String transactionId;
    private String feeId;
    private double bid;
    private double ask;
    private String typeOfExchange;

    public MarketOrderRequest() {
        super();
    }

    public MarketOrderRequest(String orderId, String transactionId, String feeId, double bid, double ask, String typeOfExchange) {
        super();
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.feeId = feeId;
        this.bid = bid;
        this.ask = ask;
        this.typeOfExchange = typeOfExchange;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getTypeOfExchange() {
        return typeOfExchange;
    }

    public void setTypeOfExchange(String typeOfExchange) {
        this.typeOfExchange = typeOfExchange;
    }

}
