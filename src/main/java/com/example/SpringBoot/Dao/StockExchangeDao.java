package com.example.SpringBoot.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot.Model.Company;
import com.example.SpringBoot.Model.StockExchange;

/*public interface StockExchangeDao {
	public boolean insertStockRecord(StockExchange stockExchange) throws Exception;

	public StockExchange updateStockRecord(StockExchange stockExchange);

	public List<StockExchange> getStockList() throws Exception;

}*/
public interface StockExchangeDao extends JpaRepository<StockExchange, Integer> {
	  
}
