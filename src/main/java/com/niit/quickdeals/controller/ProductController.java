package com.niit.quickdeals.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.Category;
import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.categorymodel.Supplier;
import com.niit.quickdeals.dao.CategoryDAO;
import com.niit.quickdeals.dao.ProductDAO;
import com.niit.quickdeals.dao.SupplierDAO;




@Controller
public class ProductController {
	
	//product.jsp -addproduct ,deleteproduct,showproductList,updateproduct,editproduct
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private HttpSession session;
	

	@RequestMapping(value = "/list_products" ,method = RequestMethod.GET)
	public ModelAndView listproducts() {
		
		log.debug(" Starting of the method listproducts");
		
		ModelAndView model = new ModelAndView ("/Admin/AdminHome");
	
		model.addObject("product", product);
		model.addObject("productList", productDAO.list());
		model.addObject("category", category);
		model.addObject("categoryList", categoryDAO.list());
		model.addObject("supplier", supplier);
		model.addObject("supplierList", supplierDAO.list());
		model.addObject("isAdminClickedproducts", true);
		log.debug(" End of the method listproducts");
		return model;
	}
	
	
//	@RequestMapping(value = "/add_Product_Value",method = RequestMethod.POST )

	@RequestMapping(value = "/add_Product_Value" , method = {RequestMethod.POST})
	public String addProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,
			HttpServletRequest request,@RequestParam String action ,Model model)
	{
		log.debug("The Starting  of Add Method");
		log.info("the product id is"+product.getId());
		log.info("the product id is"+product.getName());
		log.info("the product id is"+product.getDescription());
		log.info("the product id is"+product.getCategory_id());
		log.info("the product id is"+product.getSupplier_id());
		log.info("the product id is"+product.getFile());
		
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("products", productDAO.list());
			System.out.println("Found Errors in inputs");
			return "/admin";
		}
		
		if(action.equals("save")){
			
			log.debug(" Starting of the method addproduct");
			
			productDAO.saveOrUpdate(product);
			
			MultipartFile file = product.getFile();
			String originalFile = file.getOriginalFilename();

			String filepath = request.getSession().getServletContext().getRealPath("resources/images/");
			System.out.println("File path is " + filepath);
			String filename = filepath + "\\" + product.getId() + ".jpg";
			System.out.println("File path is " + filepath);

			try {
				byte image[] = product.getFile().getBytes();
				BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(filename));
				bof.write(image);
				bof.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			productDAO.saveOrUpdate(product);
			
			MultipartFile file = product.getFile();
			String originalFile = file.getOriginalFilename();

			String filepath = request.getSession().getServletContext().getRealPath("resources/images/");
			System.out.println("File path is " + filepath);
			String filename = filepath + "\\" + product.getId() + ".jpg";
			System.out.println("File path is " + filepath);

			try {
				byte image[] = product.getFile().getBytes();
				BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(filename));
				bof.write(image);
				bof.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedproducts", true);		
	return "/Admin/AdminHome";
	}
	
	
	@RequestMapping(value = "manage_Product_delete/{id}")
	public ModelAndView deleteproduct(@PathVariable("id") String id, Model model)
	
	{
		log.debug(" Starting of the method deleteproduct");
		
		boolean flag = productDAO.delete(id);
		String msg ="Succesfully done Operation";
		
		if(flag==false){
			msg ="The delete operation could not be done";
		}
		model.addAttribute("msg", msg);
		ModelAndView mv = new ModelAndView("redirect:/list_products");
		
		log.debug(" End of the method deleteProducts");
	return mv;
	
	}
	
	//Deleteing the Id from the table
	
	@RequestMapping("manage_Product_edit/{id}")
	public String editproduct(@PathVariable("id") String id, Model model) {
		 
		log.debug(" Starting of the method editproduct");

		product = productDAO.getProductByID(id);
	
		//model.addAttribute("product", product);
		log.debug(" End of the method editproduct");
		return "redirect:/list_products";
	}
	
	@RequestMapping("details_get/{id}")
	public ModelAndView viewdetails(@PathVariable("id") String id){
		
		log.debug(" Starting of the method deatils product");
		ModelAndView mv =  new ModelAndView("/home");
		session.setAttribute("isProductClicked","true");
		mv.addObject("product",  productDAO.getProductByID(id));
		mv.addObject("sucessMessage", "This is Product List");
		
		log.debug(" End of the method details product");
		return mv;
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") String id)
	{
		ModelAndView mv= new ModelAndView("/home");
		mv.addObject("pro", productDAO.list());
		mv.addObject("showMe", true);
		mv.addObject("cat", id);
		return mv;
	}
	
	
	
}