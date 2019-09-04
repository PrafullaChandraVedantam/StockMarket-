
package com.example.SpringBoot.Model;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class StockPrice {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "stock_code")
	private int stockCode;

	// private List stockExchange;
	@Column(name = "current_price")
	private double currentPrice;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Override
	public String toString() {
		return "StockPrice [stockCode=" + stockCode + ", currentPrice=" + currentPrice + ", date=" + date + ", time="
				+ time + ", companyCode=" + companyCode + ", stockName=" + stockName + "]";
	}

	@Column(name = "time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;

	
	@Column(name = "company_code")
	private Integer companyCode;
	
	@Column(name = "stock_name")
	private String stockName;
	

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getStockCode() {
		return stockCode;
	}

	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
