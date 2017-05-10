package com.niit.quickdeals.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.UserDAO;

@Controller
public class UserController {
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	public User user;

	@Autowired
	public UserDAO userDAO;

	/*
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 * String registrationProcess(@ModelAttribute("form-reg") User user, Model
	 * model) { userDAO.save(user); model.addAttribute("registred", "true");
	 * return "/home"; }
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("from-reg") User user, Model model) {
		user.setRole("ROLE_USER");
		if (userDAO.save(user) == true) {

			model.addAttribute("msg", "Successfully registred");
			model.addAttribute("registred", "true");
		} else {
			model.addAttribute("msg", "not able to register");
		}
		return "/home";

	}

	@RequestMapping("/contactUsNow")
	public ModelAndView contactUs() {
		System.out.println("click on contact link");
		//ModelAndView mv = new ModelAndView("/home");
		
		System.out.println("click on contact link");
	//	mv.addObject("isUserClickContactUs", "ture");
		
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickContactUs", "true");
		return mv;

	}
}
