package com.example.SpringBoot.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="company")
public class Company {

	@Column(name="company_name")
	@NotEmpty(message = "Enter the company name")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter the username containing only alphabets")
	private String companyName;

	@Column(name="turnover")
	private BigDecimal turnover;
	
	@Column(name="ceo")
	@NotEmpty(message = "please enter the CEO Name")
	private String ceo;
	
	@Column(name="board_of_directors")
	@NotEmpty(message = "please enter board of directors")
	private String boardOfDirectors;

	//private List stockExchangeLists;
	
	@Column(name="brief_writeup")
	//@NotNull
	@NotEmpty(message = "Briefly write about company")
	private String briefWriteup;
	/*
	@Column(name="stock_code")
	private int stockCode;*/
	
	@Id
	@Column(name="company_code")
	@NotNull(message = "Enter company code")
	private int companyCode;
	
	
	@Column(name="sector_id")
	@NotNull(message = "Enter sector ID")
	private Integer sectorId;
	
	/*@Column(name="sector_id")
	private int sectorId;*/

	/*public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
*/
	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	/*public List getStockExchangeLists() {
		return stockExchangeLists;
	}

	public void setStockExchangeLists(List stockExchangeLists) {
		this.stockExchangeLists = stockExchangeLists;
	}*/

	public String getBriefWriteup() {
		return briefWriteup;
	}

	public void setBriefWriteup(String briefWriteup) {
		this.briefWriteup = briefWriteup;
	}
/*
	public int getStockCode() {
		return stockCode;
	}

	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}*/

	
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", turnover=" + turnover + ", ceo=" + ceo + ", boardOfDirectors="
				+ boardOfDirectors + ", briefWriteup=" + briefWriteup + ", companyCode=" + companyCode + "]";
	}

	public Integer getSectorId() {
		return sectorId;
	}

	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	

	
}
