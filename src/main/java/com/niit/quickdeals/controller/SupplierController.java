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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.dao.SupplierDAO;



@Controller
public class SupplierController {
	
	//Supplier.jsp -addSupplier ,deleteSupplier,showSupplierList,updateSupplier,editSupplier
	
		private static Logger log = LoggerFactory.getLogger(SupplierController.class);
		
		
		@Autowired
		private Supplier supplier;
		
		@Autowired
		private SupplierDAO supplierDAO;
		
		
		
		@RequestMapping(value = "/list_Suppliers", method = RequestMethod.GET)
		public ModelAndView listSuppliers() {
			
			log.debug(" Starting of the method listSuppliers");
			
			ModelAndView model = new ModelAndView ("/Admin/AdminHome");
		
			model.addObject("supplier", supplier);
			model.addObject("supplierList", supplierDAO.list());
			model.addObject("isAdminClickedSuppliers", "true");
			log.debug(" End of the method listSuppliers");
			return model;
		}
		
		
		@RequestMapping(value = "/add_Supplier_Value" ,method = RequestMethod.POST)
		public ModelAndView AddSupplier(@ModelAttribute("supplier") Supplier supplier,@RequestParam String action)
		
		{
			
//			if(result.hasErrors()){
//				ModelAndView mv =new ModelAndView("/Admin/AdminHome");
//				
//				mv.addObject("message", " Supplier Binding has error");
//				}
//			
			ModelAndView mv =new ModelAndView("/Admin/AdminHome");
			
			if(action.equals("save"))
			{
			log.debug(" Starting of the method addSupplier");
			supplier.setId(supplier.getId());
			supplier.setName(supplier.getName());
			supplier.setAddress(supplier.getAddress());
			
				if(supplierDAO.save(supplier))
				{
					
						mv.addObject("message", "Succesfully created");
				}
				else
				{
						mv.addObject("message", "Not able to create the Supplier");
				}
					log.debug(" End of the method addSuppliers");
			}
		
			mv.addObject("supplier", supplier);
			mv.addObject("supplierList", supplierDAO.list());
			mv.addObject("isAdminClickedSuppliers", "true");
			
			
			
		return mv;
		}
		
		
		
		@RequestMapping(value = "manage_Supplier_delete/{id}")
		public ModelAndView deleteSupplier(@PathVariable("id") String id, Model model)
		
		{
			log.debug(" Starting of the method deleteSupplier");
			
			boolean flag = supplierDAO.delete(id);
			String msg ="Succesfully done Operation";
			
			if(flag==false){
				msg ="The delete operation could not be done";
			}
			model.addAttribute("msg", msg);
			ModelAndView mv = new ModelAndView("forward:/list_Suppliers");
			
			log.debug(" End of the method deleteSuppliers");
		return mv;
		
		}
		
		//Deleteing the Id from the table
		
		@RequestMapping("manage_Supplier_edit/{id}")
		public String editSupplier(@PathVariable("id") String id, Model model) {
			 
			log.debug(" Starting of the method editSupplier");

			supplier = supplierDAO.getSupplierByID(id);
		
			//model.addAttribute("Supplier", Supplier);
			log.debug(" End of the method editSupplier");
			return "forward:/list_Suppliers";
		}	
		
		

}