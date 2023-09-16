package com.fxtradingmicroservice.fxtrade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	
	
	private int currencyExchangeId;
	private String currencyPair;
    private double rate;
    
    @Id
	public int getCurrencyExchangeId() {
		return currencyExchangeId;
	}
	public void setCurrencyExchangeId(int currencyExchangeId) {
		this.currencyExchangeId = currencyExchangeId;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [currencyExchangeId=" + currencyExchangeId + ", currencyPair=" + currencyPair
				+ ", rate=" + rate + "]";
	}
	
    
	

}
