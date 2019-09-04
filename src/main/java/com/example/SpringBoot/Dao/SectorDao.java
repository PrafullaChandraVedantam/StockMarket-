package com.example.SpringBoot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot.Model.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer> {

}
