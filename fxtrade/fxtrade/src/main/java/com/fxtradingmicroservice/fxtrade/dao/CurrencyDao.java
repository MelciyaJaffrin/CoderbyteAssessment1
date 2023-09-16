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
public class CurrencyDao {
	
	@Autowired
	SessionFactory factory;

	public List<CurrencyExchange> getAllCurrencyPair() {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyExchange.class);
		return criteria.list();
	}
	
	public String addCurrencyPairs(CurrencyExchange currencyExchange) {
		Session session = factory.openSession();
		session.save(currencyExchange);
		session.beginTransaction().commit();
		return "Currency pair created ";
	}
	
	

}
