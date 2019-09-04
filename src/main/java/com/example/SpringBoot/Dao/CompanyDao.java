package com.example.SpringBoot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBoot.Model.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {
	
	public List<Company> findBysectorId(@Param("sectorId") Integer sectorId);

	@Query("Select c From Company c where c.companyName like %:companyName%")
	public List<Company> findBycompanyName(@Param("companyName") String companyName);

}
