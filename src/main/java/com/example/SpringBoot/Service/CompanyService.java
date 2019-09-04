package com.example.SpringBoot.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.Company;

public interface CompanyService {

	public boolean insertCompany(Company company) throws  ApplicationException;

	public boolean updateCompany(Company company) throws ApplicationException;

	public List<Company> getCompanyList() throws ApplicationException;

}
