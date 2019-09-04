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
import com.example.SpringBoot.Model.IPODetail;
import com.example.SpringBoot.Model.User;
import com.example.SpringBoot.Service.CompanyService;
import com.example.SpringBoot.Service.IPOService;
import com.example.SpringBoot.Service.StockExchangeService;

@Controller
public class IPOControllerImpl implements IPOController {

	@Autowired
	private IPOService ipoService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private StockExchangeService stockExchangeService;

	public static final Logger LOGGER = Logger.getLogger("SpringBoot");

	@Override
	public boolean insertIPO(IPODetail ipo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = ipoService.insertIPO(ipo);
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<IPODetail> getIPOList() throws ApplicationException {
		// TODO Auto-generated method stub
		return ipoService.getIPOList();
	}

	@RequestMapping(path = "/ipoList")
	public ModelAndView getIPO() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("ipoList");
			mv.addObject("ipoList", ipoService.getIPOList());
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "/logoutIPO", method = RequestMethod.GET)
	public ModelAndView adminLogin(Model model) throws Exception {
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

	@RequestMapping(value = "/registerIpo", method = RequestMethod.GET)
	public ModelAndView registerIPO(@Valid @ModelAttribute("ipo") IPODetail ipo, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map){

		ModelAndView mav = null;
		try
		{
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("ipo", ipo);
			mav = new ModelAndView("ipoReg");
			mav.addObject("ipoList", ipoService.getIPOList());
			mav.addObject("companyList", companyService.getCompanyList());
			mav.addObject("stockList", stockExchangeService.getStockList());
			return mav;
		}
		map.addAttribute("ipo", ipo);
		ipoService.insertIPO(ipo);

		mav = new ModelAndView("ipoList");
		mav.addObject("ipoList", ipoService.getIPOList());
		mav.addObject("companyList", companyService.getCompanyList());
		mav.addObject("stockList", stockExchangeService.getStockList());
		}
		catch (ApplicationException e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		
		return mav;

	}

	@RequestMapping(path = "/createIpo")
	public ModelAndView createIPO(Model model){
		ModelAndView mv = new ModelAndView();
		try
		{
		mv.setViewName("ipoReg");
		model.addAttribute("ipo", new IPODetail());
		mv.addObject("ipoList", ipoService.getIPOList());
		mv.addObject("companyList", companyService.getCompanyList());
		mv.addObject("stockList", stockExchangeService.getStockList());
		}
		catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;

	}

	@RequestMapping(path = "/updateIPO", method = RequestMethod.GET)
	public ModelAndView updateIPO(Model model){
		ModelAndView mv = new ModelAndView();
		try
		{
		mv.setViewName("updateIPO");
		model.addAttribute("ipo", new IPODetail());
		model.addAttribute("ipoList", ipoService.getIPOList());
		model.addAttribute("companyList", companyService.getCompanyList());
		model.addAttribute("stockList", stockExchangeService.getStockList());
		}
		catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/updatedIPODisplay", method = RequestMethod.GET)
	public ModelAndView updateCompany(@ModelAttribute("ipo") IPODetail ipo, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map){

		ModelAndView mav = null;
		try
		{
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("updateIPO", ipo);
			mav = new ModelAndView("updateIPO");
			mav.addObject("ipoList", ipoService.getIPOList());
			mav.addObject("companyList", companyService.getCompanyList());
			mav.addObject("stockList", stockExchangeService.getStockList());
			return mav;
		}
		map.addAttribute("ipo", ipo);
		ipoService.updateIPO(ipo);

		mav = new ModelAndView("ipoList");
		mav.addObject("ipoList", ipoService.getIPOList());
		mav.addObject("companyList", companyService.getCompanyList());
		mav.addObject("stockList", stockExchangeService.getStockList());
		}
		catch (ApplicationException e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

}
