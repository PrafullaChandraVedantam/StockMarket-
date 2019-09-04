package com.example.SpringBoot.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBoot.Model.Sector;

public interface SectorController {
	public boolean insertSector(Sector sector) throws SQLException;

	public boolean updateSector(Sector sector);

	public List<Sector> getSectorList() throws Exception;

}
