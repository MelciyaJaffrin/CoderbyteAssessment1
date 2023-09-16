package com.fxtradingmicroservice.fxtrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxtradingmicroservice.fxtrade.entity.CurrencyExchange;
import com.fxtradingmicroservice.fxtrade.entity.TradeInfo;
import com.fxtradingmicroservice.fxtrade.service.TradeService;


@RestController
@RequestMapping("trade")
public class TradeController {

	@Autowired
	TradeService tradeService;
	
	@GetMapping("getallTrades")
	public List<TradeInfo> getTradeInfo(){
		return tradeService.getTradeInfo();
	}
	
	
	@PostMapping("bookTrade")
	public String bookTrade(@RequestBody TradeInfo tradeInfo, CurrencyExchange currency) {
		return tradeService.bookTrade(tradeInfo, currency);
	}
	
	@PostMapping("newTrade")
	public String newTrade(@RequestBody TradeInfo tradeInfo) {
		return tradeService.newTrade(tradeInfo);
	}
	
}
