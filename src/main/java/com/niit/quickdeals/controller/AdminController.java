package com.niit.quickdeals.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.dao.CategoryDAO;
import com.niit.quickdeals.dao.ProductDAO;
import com.niit.quickdeals.dao.SupplierDAO;



@Controller
public class AdminController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	HttpSession session;

	private static Logger log = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping("/manage_Categories")
	public ModelAndView manageCategories() {

		log.debug("This is in the manage category");
		session.getAttribute("loggedInUser");

		// If user is logged check it is admin or not

		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		// get the Category from database.

		List<Category> categoryList = categoryDAO.list();

		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");

		log.debug("This is Ending of manage_Category");

		return mv;
	}

	@RequestMapping("/manage_Suppliers")
	public ModelAndView manageSupplier() {

		log.debug("This is in the manage Supplier");

		session.getAttribute("loggedInUser");

		ModelAndView mv = new ModelAndView("/Admin/AdminHome");

		List<Supplier> supplierList = supplierDAO.list();

		mv.addObject("supplierList", supplierList);

		mv.addObject("supplier", supplier);

		mv.addObject("isAdminClickedSuppliers", true);

		log.debug("This is the End of manage supplier");
		return mv;
	}

	@RequestMapping("/manage_Products")
	public ModelAndView manageProduct() {

		log.debug("This is in the manage Products");

		session.getAttribute("loggedInUser");

		ModelAndView mv = new ModelAndView("/Admin/AdminHome");

		List<Product> productList = productDAO.list();
		
		List<Supplier> supplierList = supplierDAO.list();
		
		List<Category> categoryList = categoryDAO.list();

		mv.addObject("productList", productList);

		mv.addObject("product", product);
		
		mv.addObject("supplierList", supplierList);

		mv.addObject("supplier", supplier);
		
		mv.addObject("categoryList", categoryList);
		
		mv.addObject("category", category);

		mv.addObject("isAdminClickedproducts", true);

		log.debug("This is the End of manage products");

		return mv;

	}

}