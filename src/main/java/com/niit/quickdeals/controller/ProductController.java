package com.niit.quickdeals.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.dao.ProductDAO;



@Controller
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {

		//log.debug(" Starting of the method listProducts");
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
	//	log.debug(" End of the method listCategories");
		return "/admin/AdminHome";
	}

	@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		//log.debug(" Starting of the method addCategory");
		//log.info("id:" + category.getId());
		if (productDAO.saveOrUpdate(product)== true) {
			
			model.addAttribute("msg", "Successfully created/updated the product");
		} else {
			model.addAttribute("msg", "not able created/updated the product");
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("isAdminClickedProducts", "true");
		//log.debug(" Ending of the method addCategory");
		return "/admin/AdminHome";
	}

	@RequestMapping("manage_product_remove/{id}")
	// public ModelAndView deleteCategory(@PathVariable("id") String id, Model
	// model) throws Exception {
	public String deleteProduct(@PathVariable("id") String id, Model model) throws Exception {
		boolean flag = productDAO.delete(id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		/*
		 * model.addAttribute("category", category);
		 * model.addAttribute("categoryList", this.categoryDAO.list());
		 */
		model.addAttribute("msg", msg);
		// ModelAndView mv = new ModelAndView("forward:/manage_categories");
		// return mv;

		return "forward:/manage_products";
	}

	@RequestMapping("manage_product_edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		// categoryDAO.saveOrUpdate(category);
		//log.debug(" Starting of the method editCategory");

		product = productDAO.getProductByID(id);
		// model.addAttribute("category", category);
		//log.debug(" End of the method editCategory");
		return "forward:/manage_products";
	}

}