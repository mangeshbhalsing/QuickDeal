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

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.dao.CategoryDAO;


@Controller
public class CategoryController {
	
	//Category.jsp -addCategory ,deleteCategory,showCategoryList,updateCategory,editCategory
	
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@RequestMapping(value = "/list_categories", method = RequestMethod.GET)
	public ModelAndView listCategories() {
		
		log.debug(" Starting of the method listCategories");
		
		ModelAndView model = new ModelAndView ("/Admin/AdminHome");
	
		model.addObject("category", category);
		model.addObject("categoryList", categoryDAO.list());
		model.addObject("isAdminClickedCategories", "true");
		log.debug(" End of the method listCategories");
		return model;
	}
	
	
	@RequestMapping(value = "/add_Category_Value" ,method = RequestMethod.POST)
	public ModelAndView AddCategory(@ModelAttribute("category") Category category,@RequestParam String action)
	
	{
		ModelAndView mv =new ModelAndView("/Admin/AdminHome");
		
		if(action.equals("save"))
		{
		log.debug(" Starting of the method addcategory");
		category.setId(category.getId());
		category.setName(category.getName());
		category.setDescription(category.getDescription());
		
		if(categoryDAO.saveOrUpdate(category)){
			mv.addObject("message", "Succesfully created");
		}
		else
		{
			mv.addObject("message", "Not able to create the Category");
		}
		log.debug(" End of the method addCategories");
		}
		
		
		mv.addObject("category", category);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("isAdminClickedCategories", "true");
		
		
		
	return mv;
	}
	
	
	
	@RequestMapping(value = "manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id, Model model)
	
	{
		log.debug(" Starting of the method deletecategory");
		
		boolean flag = categoryDAO.delete(id);
		String msg ="Succesfully done Operation";
		
		if(flag==false){
			msg ="The delete operation could not be done";
		}
		model.addAttribute("msg", msg);
		ModelAndView mv = new ModelAndView("forward:/list_categories");
		
		log.debug(" End of the method deleteCategories");
	return mv;
	
	}
	
	//Deleteing the Id from the table
	
	@RequestMapping("manage_category_edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {
		 
		log.debug(" Starting of the method editCategory");

		category = categoryDAO.getCategoryByID(id);
	
		//model.addAttribute("category", category);
		log.debug(" End of the method editCategory");
		return "forward:/list_categories";
	}	
	
	
	
	
}