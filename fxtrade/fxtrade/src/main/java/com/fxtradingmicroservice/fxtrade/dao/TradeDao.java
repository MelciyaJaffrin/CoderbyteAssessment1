package com.fxtradingmicroservice.fxtrade.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fxtradingmicroservice.fxtrade.entity.CurrencyExchange;
import com.fxtradingmicroservice.fxtrade.entity.TradeInfo;

@Repository
public class TradeDao {
	
	@Autowired
	SessionFactory factory;
	CurrencyDao currencyDao;
	

	public List<TradeInfo> getTradeInfo() {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(TradeInfo.class);
		return criteria.list();
	}
	
	public String newTrade(TradeInfo tradeInfo) {
		Session session = factory.openSession();
		session.save(tradeInfo);
		session.beginTransaction().commit();
		return "Trade created ";
	}

	public  List<CurrencyExchange> bookTrade(TradeInfo tradeInfo) {
		List<CurrencyExchange> currencyPairs = currencyDao.getAllCurrencyPair();
		return currencyPairs;
		
	}

}
