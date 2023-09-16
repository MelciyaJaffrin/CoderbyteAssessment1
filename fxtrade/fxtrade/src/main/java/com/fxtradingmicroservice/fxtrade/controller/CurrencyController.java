package com.fxtradingmicroservice.fxtrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxtradingmicroservice.fxtrade.entity.CurrencyExchange;
import com.fxtradingmicroservice.fxtrade.service.CurrencyService;


@RestController
@RequestMapping("currencypair")
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;
	
	@GetMapping("getallCurrencyPairs")
	public List<CurrencyExchange> getAllCurrencyPair(){
		return currencyService.getAllCurrencyPair();
	}

	@PostMapping("addCurrencyPairs")
	public String addCurrencyPairs(@RequestBody CurrencyExchange currencyExchange) {
		return currencyService.addCurrencyPairs(currencyExchange);
	}
	
}
