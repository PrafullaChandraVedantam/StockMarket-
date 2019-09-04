package com.example.SpringBoot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.SpringBoot.Model.IPODetail;

public interface IPODao extends JpaRepository<IPODetail, Integer> {
	public List<IPODetail> findBycompanyCode(@Param("companyCode") Integer companyCode);
}
