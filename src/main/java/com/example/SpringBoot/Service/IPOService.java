package com.example.SpringBoot.Service;

import java.util.List;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.IPODetail;

public interface IPOService {
	public boolean insertIPO(IPODetail ipo) throws ApplicationException;

	public boolean updateIPO(IPODetail ipo) throws ApplicationException;

	public List<IPODetail> getIPOList() throws ApplicationException;

}
