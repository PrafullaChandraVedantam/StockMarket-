package com.example.SpringBoot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="stock_exchange")
public class StockExchange {
	@Id
	@Column(name="stock_exchange_id")
	private int stockExchangeId;
	@Column(name="stock_exchange_name")
	@NotEmpty(message = "Enter the Stock name")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter the stock name containing only alphabets")
	private String stockExchangeName;
	@Column(name="brief")
	@NotEmpty(message = "Briefly write about stock")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter the brief containing only alphabets")
	private String brief;
	
	@Column(name="contact_address")
	@NotEmpty(message = "Enter the contact Address")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter the address containing only alphabets")
	private String contactAddress;
	@Column(name="remarks")
	@NotEmpty(message = "Enter the Remarks")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter the remarks containing only alphabets")
	private String remarks;
	public int getStockExchangeId() {
		return stockExchangeId;
	}
	public void setStockExchangeId(int stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "StockExchange [stockExchangeId=" + stockExchangeId + ", stockExchangeName=" + stockExchangeName
				+ ", brief=" + brief + ", contactAddress=" + contactAddress + ", remarks=" + remarks + "]";
	}
	
	
	

}
