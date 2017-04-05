package com.niit.quickdeals.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.UserDAO;

@Controller
public class UserController {
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	public User user;
	@Autowired
	public UserDAO userDAO;

/*	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registrationProcess(@ModelAttribute("form-reg") User user, Model model) {
		userDAO.save(user);
		model.addAttribute("registred", "true");
		return "/home";
	}*/
	
	  /*@PostMapping(value = "/register") 
	  public String signUp(@Valid @ModelAttribute("user") User user, BindingResult result,
	  HttpServletRequest request, Model model) {
	  
	  if (result.hasErrors()) { System.out.println("Found Errors in inputs");
	  return "/register"; }
	  
	  model.addAttribute("user", new User()); userDAO.save(user);
	  
	  return "redirect:/login"; }
	 
	 
	  @RequestMapping("/register") 
	  public ModelAndView registerPage() {
	  ModelAndView mv = new ModelAndView("register");
	  mv.addObject("user",new User()); 
	  return mv; 
	  }*/
	  
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
		public String addUser(@ModelAttribute("from-reg") User user, Model model) {
		
			if (userDAO.save(user) == true) {

				model.addAttribute("mesg", "Successfully registred");
				model.addAttribute("registred","true");
			} else {
				model.addAttribute("mesg", "not able register");
			}
	 return "/home";

}
}
