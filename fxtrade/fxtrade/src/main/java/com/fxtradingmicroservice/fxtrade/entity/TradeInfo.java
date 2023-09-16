package com.fxtradingmicroservice.fxtrade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TradeInfo {

	private int tradeNumber;
    private String customerName;
    private String currencyPair;
    private double rate;
    private double amount;
    private double convertedAmount;
    
    @Id
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	@Override
	public String toString() {
		return "TradeInfo [tradeNumber=" + tradeNumber + ", customerName=" + customerName + ", currencyPair="
				+ currencyPair + ", rate=" + rate + ", amount=" + amount + ", convertedAmount=" + convertedAmount + "]";
	}
	
    
    
    
}
