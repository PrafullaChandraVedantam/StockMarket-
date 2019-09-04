package com.example.SpringBoot.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBoot.Model.StockPrice;


public interface StockPriceDao extends JpaRepository<StockPrice, Integer>{

	public List<StockPrice> findBycompanyCode(@Param("companyCode") Integer companyCode);
	
	@Query("Select s From StockPrice s where s.companyCode=:companyCode and s.date between :startdate and :enddate")
    public List<StockPrice> findBydate(@Param("companyCode") int companyCode,@Param("startdate")Date startdate,@Param("enddate")Date enddate);

	@Query("select s.currentPrice from StockPrice s where s.companyCode=:companyCode and s.date between :date1 and :date2")
    public List<Double> findBycompanyCode(@Param(value="companyCode") Integer companyCode,@Param(value = "date1") Date date1, @Param(value = "date2") Date date2);

}
