package com.example.SpringBoot.Service;

import java.util.List;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.StockExchange;



public interface StockExchangeService {
	public boolean insertStockRecord(StockExchange stockExchange) throws ApplicationException;
   public boolean updateStockRecord(StockExchange stockExchange) throws ApplicationException;
	public List<StockExchange> getStockList() throws ApplicationException;
}
