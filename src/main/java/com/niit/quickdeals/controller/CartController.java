package com.niit.quickdeals.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quickdeals.categorymodel.MyCart;
import com.niit.quickdeals.categorymodel.Product;
import com.niit.quickdeals.dao.CartDAO;
import com.niit.quickdeals.dao.ProductDAO;


@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart myCart;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	/*@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model) {
		log.debug("Starting of the method myCart");
		model.addAttribute("myCart", new MyCart());
		// get the logged-in user id
				
		log.debug("start of the method myCart");
			String loggedInUser = (String) session.getAttribute("loggedInUser");
		if (loggedInUser == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUser = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}
		log.debug("start of the method myCart");

		int cartSize = cartDAO.list(loggedInUser).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUser));
			model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUser));
			model.addAttribute("displayCart", "true");

		}
		log.debug("Ending of the method myCart");
		return "/home";
	}*/
	
	@RequestMapping("/all")
	public ModelAndView showall()
	{
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("cart", myCart);
		mv.addObject("Cart", cartDAO.list("cart"));
		
		mv.addObject("displayCart", "true");
		return mv;
		
	}
	

	// For add and update myCart both
	@RequestMapping(value = "addToCart/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id) {
		log.debug("Starting of the method addToCart" + id );
		// get the product based on product id
		Product product = productDAO.getProductByID(id);
		myCart.setPrice(product.getPrice());
		myCart.setProduct_name(product.getName());
		
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		if (loggedInUser == null) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUser = auth.getName();
		}
	//	myCart.setId(11l);
		myCart.setQuantity("1");
		myCart.setUser_id(loggedInUser);
		//It is not required if you given default value while creating the table
		myCart.setStatus("N"); // Status is New. Once it is dispatched, we can
								// changed to 'D'
		
		//To get sequence number, you can do programmatically in DAOImpl
		//myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		
		cartDAO.save(myCart);
		// return "redirect:/views/home.jsp";

		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject("successMessage", " Successfuly add the product to myCart");
		log.debug("Ending of the method addToCart");
		return mv;
		

	}

	

	
	
	
}
