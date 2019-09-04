package com.example.SpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBoot.Dao.SpDao;
import com.example.SpringBoot.Model.Company;
import com.example.SpringBoot.Model.StockPrice;
import com.example.SpringBoot.Model.User;
import com.example.SpringBoot.Service.SectorService;
import com.example.SpringBoot.Service.UserService;

@Controller
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SectorService sectorService;
	
	@Autowired 
	private SpDao spdao;

	@Override
	public boolean registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.registerUser(user);
	}
	@RequestMapping(path = "/")
	public ModelAndView gStocks()
	{
		List<StockPrice> sp = spdao.getAllStocks();
		System.out.println("In controller");
		System.out.println(sp);
		return new ModelAndView("detailresult","res_list",sp);
	}
	
	
	
	@RequestMapping(path = "/userRegistration", method = RequestMethod.GET)
	public ModelAndView registerUser(Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userReg");
		model.addAttribute("userRegister", new User());
		return mav;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView registerAdmin(@Valid @ModelAttribute("userRegister") User user, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		if (result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			map.addAttribute("userRegister", user);
			mav = new ModelAndView("userReg");
			return mav;
		}
		map.addAttribute("userRegister", user);
		userService.registerUser(user);
		if (user.getUsertype().equalsIgnoreCase("admin")) {
			map.addAttribute("loginAdmin", new User());
			mav = new ModelAndView("adminLogin");
		} else if (user.getUsertype().equalsIgnoreCase("user")) {
			map.addAttribute("userLogin", new User());
			mav = new ModelAndView("userLogin");
		}

		return mav;

	}

	@RequestMapping(path = "/adminLogin", method = RequestMethod.GET)
	public ModelAndView adminLogin(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminLogin");
		model.addAttribute("loginAdmin", new User());
		return mv;
	}

	@RequestMapping(path = "/userLogin", method = RequestMethod.GET)
	public ModelAndView userLogin(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userLogin");
		model.addAttribute("userLogin", new User());
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView adminLogin(@ModelAttribute("loginAdmin") User user, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		map.addAttribute("loginAdmin", user);
		int check = userService.loginUser(user);
		if (check == 1) {
			// mav = new ModelAndView("companyReg");
			mav = new ModelAndView("adminLandingPage");
			map.addAttribute("company", new Company());
			mav.addObject("sectorList", sectorService.getSectorList());

		} else
			mav = new ModelAndView("adminLogin");

		return mav;

	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("userLogin") User user, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		map.addAttribute("userLogin", user);
		int check = userService.loginUser(user);
		if (check == 1)
			mav = new ModelAndView("userLandingPage");
		else
			mav = new ModelAndView("userLogin");

		return mav;

	}

	@Override
	public int loginUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userService.loginUser(user);
	}

}
