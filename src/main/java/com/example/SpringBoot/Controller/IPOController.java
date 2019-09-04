package com.example.SpringBoot.Controller;

import java.util.List;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.IPODetail;

public interface IPOController {
	public boolean insertIPO(IPODetail ipo) throws ApplicationException;

	public List<IPODetail> getIPOList() throws ApplicationException;
}
