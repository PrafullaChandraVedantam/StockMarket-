package com.example.SpringBoot.Controller;


import java.util.List;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.StockExchange;


public interface StockExchangeController {
	public boolean insertStockRecord(StockExchange stockExchange)throws ApplicationException;
	//public StockExchange updateStockRecord(StockExchange stockExchange);
	public List<StockExchange> getStockList() throws ApplicationException;

}
