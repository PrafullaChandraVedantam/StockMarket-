package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.Sector;

public interface SectorService {

	public boolean insertSector(Sector sector) throws ApplicationException;

	public boolean updateSector(Sector sector) throws ApplicationException;

	public List<Sector> getSectorList() throws ApplicationException;

}
