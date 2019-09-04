package com.example.SpringBoot.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.Dao.CompanyDao;
import com.example.SpringBoot.Dao.StockPriceDao;
import com.example.SpringBoot.Model.Company;
import com.example.SpringBoot.Model.StockPrice;

@RestController
public class StockPriceRestController {

	@Autowired
	StockPriceDao stockPriceDao;

	@Autowired
	CompanyDao companyDao;

	@GetMapping(value = "/stockPriceDetailsByCompanyId/{companyCode}")
	public List<StockPrice> SectorList(@PathVariable("companyCode") Integer companyCode) {

		List<StockPrice> stockPriceDetails = stockPriceDao.findBycompanyCode(companyCode);
		return stockPriceDetails;
	}

	@GetMapping("/stockpricedetail/{companyCode}/{startdate}/{enddate}")
	public List<StockPrice> getStockPriceDetail(@PathVariable("companyCode") int companyCode,
			@PathVariable("startdate") Date startdate, @PathVariable("enddate") Date enddate) {
		return stockPriceDao.findBydate(companyCode, startdate, enddate);
	}

	@GetMapping("/stockPriceByCompanyCode/{sectorId}/{date1}/{date2}")
	public double getStockPriceBySectorId(@PathVariable("sectorId") Integer sectorId, @PathVariable("date1") Date date1,@PathVariable("date2") Date date2) {

		double sum = 0.0;
		List<Double> stockPriceList = new ArrayList<>();
		List<Company> companyList = companyDao.findBysectorId(sectorId);
		for (int loop = 0; loop < companyList.size(); loop++) {
			Company c = (Company) companyList.get(loop);
			int companyCode = c.getCompanyCode();
			stockPriceDao.findBycompanyCode(companyCode, date1, date2).forEach(stockPriceList::add);
		}

		for (Double price : stockPriceList) {
			sum = sum + price;
		}
		return sum;

	}

}
