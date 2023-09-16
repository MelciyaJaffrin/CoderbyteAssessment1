package com.fxtradingmicroservice.fxtrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtradingmicroservice.fxtrade.dao.CurrencyDao;
import com.fxtradingmicroservice.fxtrade.dao.TradeDao;
import com.fxtradingmicroservice.fxtrade.entity.CurrencyExchange;
import com.fxtradingmicroservice.fxtrade.entity.TradeInfo;
import com.fxtradingmicroservice.fxtrade.exception.InvalidAmountException;
import com.fxtradingmicroservice.fxtrade.exception.InvalidInputException;

@Service
public class TradeService {
	
	@Autowired 
	TradeDao tradeDao;
	CurrencyDao currencyDao;
	
	public List<TradeInfo> getTradeInfo() {
		return tradeDao.getTradeInfo();
	}


	public String bookTrade(TradeInfo tradeInfo, CurrencyExchange currency) {
		
		List<CurrencyExchange> currencyPairs = tradeDao.bookTrade(tradeInfo);
        double convertedAmount =1;        
        for (CurrencyExchange currencyPair : currencyPairs) {
        	if (!currencyPair.getCurrencyPair().equals(tradeInfo.getCurrencyPair())){
        		
        		throw new InvalidInputException("Invalid Input entered! Please give valid input.");  
       		
            }
        	if(tradeInfo.getAmount()<0) {
        		throw new InvalidAmountException("Enet valid Amount");
        	}
        	else {
                convertedAmount = tradeInfo.getAmount()*currencyPair.getRate();
        		
        		TradeInfo trades = new TradeInfo();
        		trades.setCustomerName(tradeInfo.getCustomerName());
        		trades.setCurrencyPair(currencyPair.getCurrencyPair());
        		trades.setRate(currencyPair.getRate());
        		trades.setAmount(tradeInfo.getAmount());
        		trades.setConvertedAmount(convertedAmount);   
        		
        	}
		}       
        return "Trade booked";   
        
	}
	
	  public String newTrade(TradeInfo tradeInfo) {
			
			return tradeDao.newTrade(tradeInfo);
		}

        

      
}
