package com.example.asssignment.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class FeeResponse {
    private String feeId;
    private String feeType;
    private float feeAmount;
    private LocalDate feeDate;
    private LocalTime feeTime;
    private float salesTax;

	public FeeResponse() {
		super();
	}
    
    public FeeResponse(String feeId, String feeType, float feeAmount, LocalDate feeDate, LocalTime feeTime, float salesTax) {
        this.feeId = feeId;
        this.feeType = feeType;
        this.feeAmount = feeAmount;
        this.feeDate = feeDate;
        this.feeTime = feeTime;
        this.salesTax = salesTax;
    }

    public String getFeeId() {
        return feeId;
    }

    public String getFeeType() {
        return feeType;
    }

    public float getFeeAmount() {
        return feeAmount;
    }

    public LocalDate getFeeDate() {
        return feeDate;
    }

    public LocalTime getFeeTime() {
        return feeTime;
    }

    public float getSalesTax() {
        return salesTax;
    }

    public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public void setFeeAmount(float feeAmount) {
		this.feeAmount = feeAmount;
	}

	public void setFeeDate(LocalDate feeDate) {
		this.feeDate = feeDate;
	}

	public void setFeeTime(LocalTime feeTime) {
		this.feeTime = feeTime;
	}

	public void setSalesTax(float salesTax) {
		this.salesTax = salesTax;
	}

	@Override
    public String toString() {
        return "FeeResponse [feeId=" + feeId + ", feeType=" + feeType + ", feeAmount=" + feeAmount + ", feeDate=" + feeDate
                + ", feeTime=" + feeTime + ", salesTax=" + salesTax + "]";
    }
}