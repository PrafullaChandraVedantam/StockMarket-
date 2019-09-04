package com.example.SpringBoot.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot.Model.StockPrice;



@Repository
public class SpDao{

	@Autowired
	private EntityManager manager;
	@Transactional
	public List<StockPrice> getAllStocks() {
		System.out.println("working");
	/*	Query q = manager.createQuery("from StockPrice");
		System.out.println(q.getResultList());
		 return q.getResultList();*/
		 List<StockPrice> stockPriceList = new ArrayList<>();
		try
		{
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul?useSSL=false",
						"root", "pass@word1");
				PreparedStatement preparedStatement = conn.prepareStatement("select * from StockPrice");
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println(rs);
				StockPrice stockPrice = null;
				while (rs.next()) {
					stockPrice = new StockPrice();
				
				  stockPrice.setCompanyCode(rs.getInt("company_code"));
				  stockPrice.setCurrentPrice(rs.getDouble("current_price"));
				  stockPrice.setStockCode(rs.getInt("stock_code"));
				  stockPrice.setStockName(rs.getString("stock_name"));
				 
					
					stockPriceList.add(stockPrice);
				}
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		System.out.println(stockPriceList);
		return stockPriceList;
				
	}
	
}