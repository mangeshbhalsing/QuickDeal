package com.niit.quickdeals.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.categorymodel.User;
import com.niit.quickdeals.dao.CategoryDAO;
import com.niit.quickdeals.dao.ProductDAO;
import com.niit.quickdeals.dao.SupplierDAO;
import com.niit.quickdeals.dao.UserDAO;

@Controller
public class HomeController {

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Category category;

	@Autowired

	private CategoryDAO categoryDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

	// http://localhost:8080/qucikdeals/
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public ModelAndView langdingpage() {
		// log.debug("running landing page");
		System.out.println("starting the method showing homepage");
		// specifying which page you have to navigate
		ModelAndView mv = new ModelAndView("/home");
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("producList", productDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("productList", productDAO.list());

		// mv.addObject("not empty"," welcome to quickdeals");
		// show what data you have to carry on home page
		mv.addObject("message", "welcome to quickdeals");
		mv.addObject("thisIsHome", "true");

		// log.debug("ending landing page");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView landingpage() {
		// log.debug("running landing page");
		System.out.println("starting the method showing homepage");
		// specifying which page you have to navigate
		ModelAndView mv = new ModelAndView("/home");
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("producList", productDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("productList", productDAO.list());

		// mv.addObject("not empty"," welcome to quickdeals");
		// show what data you have to carry on home page
		mv.addObject("message", "welcome to quickdeals");
		mv.addObject("thisIsHome", "true");

		// log.debug("ending landing page");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView loginpage() {
		// log.debug("running login page");
		System.out.println("click on login link");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickedLogin", "true");
		// log.debug("ending login page");
		return mv;
	}

	@RequestMapping("/women")
	public ModelAndView womenSort() {
		// log.debug("running login page");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickedWomen", "true");
		// log.debug("ending login page");
		return mv;
	}
	/*
	 * @RequestMapping("/carousel") public ModelAndView carouselpage() {
	 * System.out.println("User is on home page"); ModelAndView mv = new
	 * ModelAndView("/home"); mv.addObject("isUserOnHOmePage", "true"); return
	 * mv; }
	 */

	/*
	 * @RequestMapping("/registration") public ModelAndView registerationpage()
	 * { //log.debug("running registeration page");
	 * System.out.println("click on registeration link"); ModelAndView mv = new
	 * ModelAndView("/home"); //mv.addObject("isUserClickRegister", "true");
	 * //log.debug("ending registeration page"); return mv; }
	 */

	/*
	 * @RequestMapping("/validation") public ModelAndView
	 * validation(@RequestParam("username") String id, @RequestParam("password")
	 * String pwd) { // log.debug("running validation  method"); ModelAndView mv
	 * = new ModelAndView("/home"); mv.addObject("empty" ,"loginMessage"); //
	 * mv.addObject("isUserLoggedIn", "false"); if (userDAO.validate(id, pwd) ==
	 * true) { mv.addObject("isUserLoggedIn", "ture"); user =
	 * userDAO.getUser(id);
	 * 
	 * 
	 * if (user.getRole().equals("admin")) { mv = new ModelAndView("/home");
	 * mv.addObject("isAdmin", "true");
	 * 
	 * } else { mv.addObject("isAdmin", "false"); }
	 * 
	 * mv.addObject("msg", "Valid Credential");
	 * session.setAttribute("loginMessage", "Welcome" + " " + id);
	 * 
	 * } else {
	 * 
	 * mv.addObject("msg", "InValid Credential please try again");
	 * 
	 * } //log.debug("ending validation  method"); return mv;
	 * 
	 * }
	 */

	@RequestMapping(value = "validate", method = RequestMethod.GET)
	public ModelAndView validate(HttpServletRequest request, HttpServletRequest response) throws Exception {
		// log.debug("Starting of the method validate");
		ModelAndView mv = new ModelAndView("/home");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String userID = auth.getName();
		// log.info( userID );
		session.setAttribute("loggedInUser", userID);

		if (request.isUserInRole("ROLE_ADMIN")) {
			// log.debug("Logged in as Admin");
			mv = new ModelAndView("/Admin/AdminHome");

			// session.setAttribute("isAdmin", "true");
			session.setAttribute("AdminLoggedIn", "true");
		} else {
			// log.debug("Logged in as User");
			session.setAttribute("isAdmin", "false");
			// List<MyCart> cartList = cartDAO.list(name);
			// mv.addObject("cartList" , cartList);
			// mv.addObject("cartSize", cartList.size());
			// mv.addObject("totalAmount",cartDAO.getTotalAmount(userID));

		}
		mv.addObject("successMessage", "Valid Credentials ");
		mv.addObject("thisIsHome", true);

		session.setAttribute("loginMessage", "Welcome :" + userID);
		session.setAttribute("userLogin", "true");

		session.setAttribute("loggedInUser", userID);

		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("producList", productDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("productList", productDAO.list());

		// log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		model.addAttribute("isUserClickedLogin", "true");
		log.debug("Ending of the method loginError");
		return "/home";

	}

	// <security:access-denied-handler error-page="/accessDenied" />
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "/home";
	}
	/*
	 * @RequestMapping("/proDetails/logout") public String
	 * productDetailsLogout(@PathVariable("id") String id, Model model) {
	 * 
	 * model.addAttribute("product",productDAO.getProductByID(id));
	 * model.addAttribute("thisIsHome", true); return "redirect:/home"; }
	 */

	@RequestMapping("/logout")
	public ModelAndView logout() {
		// log.debug("running logout method");
		ModelAndView mv = new ModelAndView("forward:/home");
		session.invalidate();
		// mv.addObject("isUserClickLogout","true");
		// log.debug("endig logout method");
		mv.addObject("successMessage", "success fully logged-out");
		mv.addObject("thisIsHome", "true");

		return mv;

	}

	@RequestMapping("/refresh")
	public ModelAndView Home() {
		// log.debug("running logout method");
		ModelAndView mv = new ModelAndView("forward:/home");
		mv.isReference();
		mv.addObject("thisIsHome", "true");
	//	mv.addObject
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("producList", productDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("productList", productDAO.list());

		return mv;

	}

}
