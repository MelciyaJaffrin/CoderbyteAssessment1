package com.fxtradingmicroservice.fxtrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtradingmicroservice.fxtrade.dao.CurrencyDao;
import com.fxtradingmicroservice.fxtrade.entity.CurrencyExchange;


@Service
public class CurrencyService {
	
	@Autowired
	CurrencyDao currencyDao;

	public List<CurrencyExchange> getAllCurrencyPair() {
		return currencyDao.getAllCurrencyPair();
	}
	
	public String addCurrencyPairs(CurrencyExchange currencyExchange) {
			
			return currencyDao.addCurrencyPairs(currencyExchange);
	}
	
	

}
