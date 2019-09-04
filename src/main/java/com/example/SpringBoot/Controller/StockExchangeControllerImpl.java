package com.example.SpringBoot.Controller;

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
import com.example.SpringBoot.Model.StockExchange;
import com.example.SpringBoot.Model.User;
import com.example.SpringBoot.Service.StockExchangeService;

@Controller
public class StockExchangeControllerImpl implements StockExchangeController {
	@Autowired
	private StockExchangeService stockService;
	public static final Logger LOGGER = Logger.getLogger("SpringBoot");

	@Override
	public boolean insertStockRecord(StockExchange stockExchange) throws ApplicationException {
		// TODO Auto-generated method stub

		return stockService.insertStockRecord(stockExchange);
	}

	/*
	 * @Override public StockExchange updateStockRecord(StockExchange
	 * stockExchange) { // TODO Auto-generated method stub return null; }
	 */

	@RequestMapping(path = "/logoutStock", method = RequestMethod.GET)
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

	@Override
	public List<StockExchange> getStockList() throws ApplicationException {
		// TODO Auto-generated method stub
		return stockService.getStockList();
	}

	@RequestMapping(path = "/insertStock", method = RequestMethod.GET)
	public ModelAndView registerStockPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("stockReg");
			model.addAttribute("stockRegister", new StockExchange());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "/stockList")
	public ModelAndView getCompanyList() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("stockList");
			mv.addObject("stockList", stockService.getStockList());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/stockInsert", method = RequestMethod.GET)
	public ModelAndView registerStock(@Valid @ModelAttribute("stockRegister") StockExchange stockExchange,
			BindingResult result, HttpServletRequest request, HttpSession session, ModelMap map) {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("stockRegister", stockExchange);
				mav = new ModelAndView("stockReg");
				return mav;
			}
			map.addAttribute("stockRegister", stockExchange);
			stockService.insertStockRecord(stockExchange);
			mav = new ModelAndView("stockList");
			mav.addObject("stockList", stockService.getStockList());
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(path = "/updateStock", method = RequestMethod.GET)
	public ModelAndView updateStockList(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("updateStock");
			model.addAttribute("stockExchange", new StockExchange());
			model.addAttribute("stockList", stockService.getStockList());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/stockUpdate", method = RequestMethod.GET)
	public ModelAndView updateCompany(@ModelAttribute("stockExchange") StockExchange stockExchange,
			BindingResult result, HttpServletRequest request, HttpSession session, ModelMap map) {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("stockExchange", stockExchange);
				mav = new ModelAndView("updateStock");
				map.addAttribute("stockList", stockService.getStockList());
				return mav;
			}
			map.addAttribute("stockExchange", stockExchange);
			stockService.updateStockRecord(stockExchange);

			mav = new ModelAndView("stockList");
			mav.addObject("stockList", stockService.getStockList());
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

}
