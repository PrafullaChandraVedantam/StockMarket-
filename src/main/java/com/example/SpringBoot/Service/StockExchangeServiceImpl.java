package com.example.SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.StockExchangeDao;
import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.StockExchange;


@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeDao stockExchangeDao;

	@Override
	public boolean insertStockRecord(StockExchange stockExchange) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
		 stockExchangeDao.save(stockExchange);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert StockExchange failed");
		}
		 return true;
	}

	@Override
	public boolean updateStockRecord(StockExchange stockExchange) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
		 stockExchangeDao.save(stockExchange);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Update StockExchange failed");
		}
		 return true;
	}

	@Override
	public List<StockExchange> getStockList() throws ApplicationException {
		// TODO Auto-generated method stub
		return stockExchangeDao.findAll();
	}

}
