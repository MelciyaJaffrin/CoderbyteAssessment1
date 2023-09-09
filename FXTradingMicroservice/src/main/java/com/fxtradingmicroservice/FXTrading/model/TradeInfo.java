package com.fxtradingmicroservice.FXTrading.model;


public class TradeInfo {
	
    private int tradeNumber;
    private String customerName;
    private String currencyPair;
    private double usdAmount;
    private double inrAmount;
    private double rate;
    
    String rateChoice;
    String confirmation;
    
    public TradeInfo() {
		super();
	}

    public TradeInfo(int tradeNumber, String currencyPair, String customerName,double usdAmount, double inrAmount, double rate, String confirmation) {
        this.tradeNumber = tradeNumber;
        this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.inrAmount = inrAmount;
        this.usdAmount = usdAmount;
        this.rate = rate;
        this.confirmation = confirmation;
     
    }
    
	public int getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getUsdAmount() {
		return usdAmount;
	}
	public void setUsdAmount(double usdAmount) {
		this.usdAmount = usdAmount;
	}

	public double getInrAmount() {
		return inrAmount;
	}

	public void setInrAmount(double inrAmount) {
		this.inrAmount = inrAmount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	
	public String getRateChoice() {
		return rateChoice;
	}

	public void setRateChoice(String rateChoice) {
		this.rateChoice = rateChoice;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "TradeInfo [tradeNumber=" + tradeNumber + ", customerName=" + customerName + ", currencyPair="
				+ currencyPair + ", inrAmount=" + inrAmount + ", rate=" + rate + "]";
	}
	   
    
}

