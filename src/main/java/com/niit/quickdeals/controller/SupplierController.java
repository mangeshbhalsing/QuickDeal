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

import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.dao.SupplierDAO;





@Controller
public class SupplierController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value = "/manage_Suppliers", method = RequestMethod.GET)
	public String listCategories(Model model) {
		
		log.debug(" Starting of the method listCategories");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug(" End of the method listCategories");
		return "/admin/AdminHome";
	}
	
	
	

	@RequestMapping(value = "/manage_supplier_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("supplier") Supplier supplier, Model model) {
		log.debug(" Starting of the method addCategory");
		log.info("id:" + supplier.getId());
		if (supplierDAO.save(supplier) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the supplier");
		} else {
			model.addAttribute("msg", "not able created/updated the supplier");
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug(" Ending of the method addCategory");
		return "/admin/AdminHome";
	}

	@RequestMapping("manage_supplier_remove/{id}")
//	public ModelAndView deleteCategory(@PathVariable("id") String id, Model model) throws Exception {
	public String deleteSupplier(@PathVariable("id") String id, Model model) throws Exception {
		boolean flag = supplierDAO.delete(id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		/*
		 * model.addAttribute("category", category);
		 * model.addAttribute("categoryList", this.categoryDAO.list());
		 */
		model.addAttribute("msg", msg);
	//	ModelAndView mv = new ModelAndView("forward:/manage_categories");
		//return mv;

		return "forward:/manage_Suppliers";
	}

	@RequestMapping("manage_supplier_edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {
		// categoryDAO.saveOrUpdate(category);
		log.debug(" Starting of the method editCategory");

		supplier =supplierDAO.getSupplierByID(id);
		//model.addAttribute("category", category);
		log.debug(" End of the method editCategory");
		return "forward:/manage_Suppliers";
	}

}