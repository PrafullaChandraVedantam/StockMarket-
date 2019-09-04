package com.example.SpringBoot.Controller;

import java.sql.SQLException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBoot.Exception.ApplicationException;
import com.example.SpringBoot.Model.Sector;
import com.example.SpringBoot.Model.StockExchange;
import com.example.SpringBoot.Model.User;
import com.example.SpringBoot.Service.SectorService;

@Controller
public class SectorControllerImpl implements SectorController {
	@Autowired
	private SectorService sectorService;
	public static final Logger LOGGER = Logger.getLogger("SpringBoot");

	@RequestMapping(path = "/createSector", method = RequestMethod.GET)
	public ModelAndView registerSector(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("sectorReg");
			model.addAttribute("sector", new Sector());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "/logoutSector", method = RequestMethod.GET)
	public ModelAndView adminLogin(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("adminLogin");
			model.addAttribute("loginAdmin", new User());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "/UpdateSector", method = RequestMethod.GET)
	public ModelAndView updatedSector(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("updateSector");
			model.addAttribute("updateSector", new Sector());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/registerSector", method = RequestMethod.GET)
	public ModelAndView registerAdmin(@Valid @ModelAttribute("sector") Sector sector, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("sector", sector);
				mav = new ModelAndView("sectorReg");
				return mav;
			}
			map.addAttribute("sector", sector);
			// companyService.insertCompany(company);
			sectorService.insertSector(sector);
			mav = new ModelAndView("sectorList");
			mav.addObject("sectorList", sectorService.getSectorList());
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/updateSector", method = RequestMethod.GET)
	public ModelAndView register(@Valid @ModelAttribute("updateSector") Sector sector, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("updateSector", sector);
				mav = new ModelAndView("updateSector");
				return mav;
			}
			map.addAttribute("updateSector", sector);
			sectorService.updateSector(sector);
			mav = new ModelAndView("sectorList");
			mav.addObject("sectorList", sectorService.getSectorList());
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(path = "/sectorList")
	public ModelAndView getSector() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("sectorList");
			mv.addObject("sectorList", sectorService.getSectorList());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public boolean insertSector(Sector sector) {
		// TODO Auto-generated method stub
		try {
			sectorService.insertSector(sector);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Sector> getSectorList() throws ApplicationException {
		// TODO Auto-generated method stub
		return sectorService.getSectorList();

	}

	@Override
	public boolean updateSector(Sector sector) {
		// TODO Auto-generated method stub
		try {
			sectorService.updateSector(sector);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}
}
