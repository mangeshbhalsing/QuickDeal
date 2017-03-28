package com.niit.quickdeals.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.UserDAO;


@Controller
public class HomeController {
	//private static Logger log = LoggerFactory.getLogger(HomeController.class);
@Autowired
private User user;

@Autowired
private UserDAO userDAO;
	


	// http://localhost:8080/qucikdeals/
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public ModelAndView langdingpage() {
	//	log.debug("running landing page");
		System.out.println("starting the method showing homepage");
		// specifying which page you have to navigate
		ModelAndView mv = new ModelAndView("home");
		// mv.addObject("not empty"," welcome to quickdeals");
		// show what data you have to carry on home page
		mv.addObject("message", "welcome to quickdeals");
		//log.debug("ending landing page");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView loginpage() {
	//	log.debug("running login page");
		System.out.println("click on login link");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickedLogin", "true");
	//	log.debug("ending login page");
		return mv;
	}
	/*
	 * @RequestMapping("/carousel") public ModelAndView carouselpage() {
	 * System.out.println("User is on home page"); ModelAndView mv = new
	 * ModelAndView("/home"); mv.addObject("isUserOnHOmePage", "true"); return
	 * mv; }
	 */

	@RequestMapping("/registration")
	public ModelAndView registerationpage() {
		//log.debug("running registeration page");
		System.out.println("click on registeration link");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickRegister", "true");
		//log.debug("ending registeration page");
		return mv;
	}

	@RequestMapping("/validation")
	public ModelAndView validation(@RequestParam("userID") String id, @RequestParam("password") String pwd) {
	//	log.debug("running validation  method");
		ModelAndView mv = new ModelAndView("/home");
		 mv.addObject("empty" ,"loginMessage");
	//	mv.addObject("isUserLoggedIn", "false");
		if (userDAO.validate(id, pwd) == true) {
			mv.addObject("isUserLoggedIn", "ture");
			user = userDAO.getUser(id);
			

			if (user.getRole().equals("admin")) {
				 mv = new ModelAndView("/home");
				mv.addObject("isAdmin", "true");
				 
			} else {
				mv.addObject("isAdmin", "false");
			}

			mv.addObject("msg", "Valid Credential");
			session.setAttribute("loginMessage", "Welcome" + " " + id);

		} else {

			mv.addObject("msg", "InValid Credential please try again");

		}
		//log.debug("ending validation  method");
		return mv;

	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		//log.debug("running logout  method");
		ModelAndView mv = new ModelAndView("home");
		session.invalidate();
		//mv.addObject("isUserClickLogout","true");
	//	log.debug("endig logout  method");
		return mv;

	}

}
