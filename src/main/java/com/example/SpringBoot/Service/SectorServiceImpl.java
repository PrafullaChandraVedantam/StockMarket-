package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.SectorDao;
import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.Sector;

@Service
public class SectorServiceImpl implements SectorService {
	@Autowired
	private SectorDao sectorDao;
	
	@Override
	public boolean insertSector(Sector sector) throws ApplicationException {
		// TODO Auto-generated method stub
		//return companyDao.insertCompany(company) ;
		try
		{
		 sectorDao.save(sector) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert sector failed");
		}
		 return true;

	}

	@Override
	public boolean updateSector(Sector sector) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
	sectorDao.save(sector) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert sector failed");
		}
		 return true;
		
	}

	@Override
	public List<Sector> getSectorList() throws ApplicationException {
		//return companyDao.getCompanyList();
		return sectorDao.findAll();
	}

	
}
