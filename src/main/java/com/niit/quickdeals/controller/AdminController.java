package com.niit.quickdeals.controller;

import java.util.List;

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
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;
	
	//@Autowired
	//HttpSession session;
	@RequestMapping("/manage_Categories")
	public ModelAndView manageCategories() {
		//log.debug("running manage categorier");
		ModelAndView mv = new ModelAndView("/admin/AdminHome");
		mv.addObject("isUserClickedCategories", "true");
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);//
		//log.debug("ending manage categorier");
		return mv;
	}

	@RequestMapping("/manage_Suppliers")
	  public ModelAndView manageSuppliers() {
		ModelAndView mv = new ModelAndView("/admin/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier", supplier);
		
		return mv;
		
		
		}

	

	@RequestMapping("/manage_Products")
	public ModelAndView manageProdcuts() {
		//log.debug("running manage categorier");
		ModelAndView mv = new ModelAndView("/admin/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		List<Product> productList = productDAO.list();
		mv.addObject("productList", productList);
		mv.addObject("product", product);//
		//log.debug("ending manage categorier");
		return mv;

	}

}
