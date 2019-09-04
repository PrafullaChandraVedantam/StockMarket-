package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.CompanyDao;
import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public boolean insertCompany(Company company) throws ApplicationException {
		// TODO Auto-generated method stub
		//return companyDao.insertCompany(company) ;
		try
		{
			 companyDao.save(company) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert company failed");
		}
		 return true;

	}

	@Override
	public boolean updateCompany(Company company) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
		companyDao.save(company) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Update company failed");
		}
		 return true;
		
	}

	@Override
	public List<Company> getCompanyList() throws ApplicationException {
		//return companyDao.getCompanyList();
		
		return companyDao.findAll();
	}

}
