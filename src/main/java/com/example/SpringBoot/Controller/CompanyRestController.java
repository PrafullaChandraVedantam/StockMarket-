package com.example.SpringBoot.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.Dao.CompanyDao;
import com.example.SpringBoot.Model.Company;


@RestController
public class CompanyRestController {

	@Autowired
	CompanyDao companyDao;

	@GetMapping(value = "/companyBySectorId/{sectorId}")
	public List<Company> SectorList(@PathVariable("sectorId") Integer sectorId) {

		List<Company> company = companyDao.findBysectorId(sectorId);
		return company;
	}
	
	@GetMapping(value = "/companyByName/{companyName}")
	public List<Company> findCompanyByLetter(@PathVariable("companyName") String companyName) {

		// List<Customer> customers = repository.findByNameAndAge(name,age);
		List<Company> companyByLetter=companyDao.findBycompanyName(companyName);
		return companyByLetter;
	}

}
