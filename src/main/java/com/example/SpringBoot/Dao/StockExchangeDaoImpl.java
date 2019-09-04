package com.example.SpringBoot.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.Model.StockExchange;


/*@Repository
public class StockExchangeDaoImpl implements StockExchangeDao{

	@Override
	public boolean insertStockRecord(StockExchange stockExchange) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockexchange?useSSL=false",
				"root", "root");
		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into stock_exchange (stock_exchange_name,brief,contact_address,remarks) values(?,?,?,?)");
		preparedStatement.setString(1, stockExchange.getStockExchangeName());
		preparedStatement.setString(2, stockExchange.getBrief());
		preparedStatement.setString(3, stockExchange.getContactAddress());
		preparedStatement.setString(4, stockExchange.getRemarks());
		preparedStatement.executeUpdate();
		return true;
	}

	@Override
	public StockExchange updateStockRecord(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockExchange> getStockList() throws Exception {
		List<StockExchange> stockExchangeList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockexchange?useSSL=false",
					"root", "root");
			PreparedStatement preparedStatement = conn.prepareStatement("select * from stock_exchange");
			ResultSet rs = preparedStatement.executeQuery();
			StockExchange stockExchange = null;
			while (rs.next()) {
				stockExchange = new StockExchange();
				stockExchange.setStockExchangeId(rs.getInt("stock_exchange_id"));
				stockExchange.setStockExchangeName(rs.getString("stock_exchange_name"));
				stockExchange.setBrief(rs.getString("brief"));
				stockExchange.setContactAddress(rs.getString("contact_address"));
				stockExchange.setRemarks(rs.getString("remarks"));
				stockExchangeList.add(stockExchange);
			}
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return stockExchangeList;

	}

}*/
