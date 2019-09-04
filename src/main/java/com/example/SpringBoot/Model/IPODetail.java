package com.example.SpringBoot.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ipo_planned")
public class IPODetail {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "company_id")
	private Integer companyCode;

	@Column(name = "Stock_exchange")
	private int stockExchange;

	@Column(name = "price_per_share")
	//@NotNull(message = "Price Should not be Empty")
	private BigDecimal priceperShare;

	@Column(name = "remarks")
	@NotEmpty(message = "Please enter Remarks")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Remarks should not contain numbers")
	private String remarks;

	@Column(name = "total_no_of_shares")
	@NotNull(message = "Please enter total number of shares")
	private int totalShares;

	@Column(name = "open_date_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date openDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public int getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(int stockExchange) {
		this.stockExchange = stockExchange;
	}

	public int getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}

	public Date getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getPriceperShare() {
		return priceperShare;
	}

	public void setPriceperShare(BigDecimal priceperShare) {
		this.priceperShare = priceperShare;
	}

	@Override
	public String toString() {
		return "IPODetail [id=" + id + ", companyCode=" + companyCode + ", stockExchange=" + stockExchange
				+ ", priceperShare=" + priceperShare + ", remarks=" + remarks + ", totalShares=" + totalShares
				+ ", openDateTime=" + openDateTime + "]";
	}

}
