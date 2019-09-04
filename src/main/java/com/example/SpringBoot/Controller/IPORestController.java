package com.example.SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.Dao.IPODao;
import com.example.SpringBoot.Model.IPODetail;

@RestController
public class IPORestController {
	
	@Autowired
	IPODao ipoDao;

	@GetMapping(value = "/ipoDetailsByCompanyId/{companyCode}")
	public List<IPODetail> SectorList(@PathVariable("companyCode") Integer companyCode) {

		List<IPODetail> ipoDetails =ipoDao.findBycompanyCode(companyCode);
		return ipoDetails;
	}

}
