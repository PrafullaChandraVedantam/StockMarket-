package com.example.SpringBoot.Controller;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.example.SpringBoot.Model.Company;
import com.example.SpringBoot.Model.User;
import com.example.SpringBoot.Service.CompanyService;
import com.example.SpringBoot.Service.SectorService;

@Controller
public class CompanyControllerImpl implements CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private SectorService sectorService;

	public static final Logger LOGGER = Logger.getLogger("SpringBoot");

	/*
	 * public boolean insertCompany(Company company) throws SQLException {
	 * return companyService.insertCompany(company);
	 * 
	 * }
	 */
	public boolean insertCompany(Company company) {
		boolean flag = false;
		try {
			flag = companyService.insertCompany(company);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	@RequestMapping(path = "/companyList")
	public ModelAndView getCompanyList() throws SQLException  {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("companyList");
			mv.addObject("companyList", companyService.getCompanyList());
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * @RequestMapping(path = "/logout", method = RequestMethod.GET) public
	 * ModelAndView adminLogin(Model model) throws Exception { ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("adminLogin");
	 * model.addAttribute("loginAdmin",new User()); return mv; }
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)

	public ModelAndView donorLogout(HttpServletRequest request, HttpServletResponse response, Model modelobj) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session!=null)
		session.invalidate();
		modelobj.addAttribute("loginAdmin", new User());
		return new ModelAndView("adminLogin");
	}

	@RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
	public ModelAndView registerAdmin(@Valid @ModelAttribute("company") Company company, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException{

		ModelAndView mav = null;
		try
		{
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("company", company);
			map.addAttribute("sectorList", sectorService.getSectorList());
			mav = new ModelAndView("companyReg");
			return mav;
		}
		map.addAttribute("company", company);
		companyService.insertCompany(company);

		mav = new ModelAndView("companyList");
		mav.addObject("companyList", companyService.getCompanyList());
		}
		catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public ModelAndView registerCompany(Model model){
		ModelAndView mv = new ModelAndView();
		try
		{
		mv.setViewName("companyReg");
		model.addAttribute("company", new Company());
		mv.addObject("sectorList", sectorService.getSectorList());
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "/updateCompany", method = RequestMethod.GET)
	public ModelAndView updateCompany(Model model){
		ModelAndView mv = new ModelAndView();
		try
		{
		mv.setViewName("updateCompany");
		model.addAttribute("updateCompany", new Company());
		model.addAttribute("sectorList", sectorService.getSectorList());
		model.addAttribute("companyList", companyService.getCompanyList());
		}
		catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/updatedDisplay", method = RequestMethod.GET)
	public ModelAndView updateCompany(@ModelAttribute("updateCompany") Company company, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map){

		ModelAndView mav = null;
		try
		{
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("updateCompany", company);
			mav = new ModelAndView("updateCompany");
		}
		map.addAttribute("updateCompany", company);
		companyService.updateCompany(company);

		mav = new ModelAndView("companyList");
		mav.addObject("companyList", companyService.getCompanyList());
		mav.addObject("sectorList", sectorService.getSectorList());
		}
		catch (ApplicationException e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

}
