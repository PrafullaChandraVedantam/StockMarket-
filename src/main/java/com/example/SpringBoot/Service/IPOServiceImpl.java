package com.example.SpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.Dao.IPODao;
import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.IPODetail;

@Service
public class IPOServiceImpl implements IPOService {
	@Autowired
	private IPODao ipoDao;

	@Override
	public boolean insertIPO(IPODetail ipo) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
		ipoDao.save(ipo);
		}
		catch(Exception e)
		{
			throw new ApplicationException("Insert IPO failed");
		}
		return true;

	}

	@Override
	public List<IPODetail> getIPOList() throws ApplicationException {
		return ipoDao.findAll();
	}

	@Override
	public boolean updateIPO(IPODetail ipo) throws ApplicationException {
		// TODO Auto-generated method stub
		try
		{
		ipoDao.save(ipo) ;
		}
		catch(Exception e)
		{
			throw new ApplicationException("Update IPO failed");
		}
		 return true;
	}

}
