package com.niit.quickdeals.controller;

import java.util.Collection;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model) {
		log.debug("Starting of the method myCart");
		model.addAttribute("myCart", new MyCart());
		// get the logged-in user id

		log.debug("start of the method myCart");
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		if (loggedInUser == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUser = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
			authorities.contains("ROLE_USER");

		}
		log.debug("start of the method myCart");

		int cartSize = cartDAO.list(loggedInUser).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUser));
			model.addAttribute("prolist", productDAO.list());
			// model.addAttribute("totalAmount",
			// cartDAO.getTotalAmount(loggedInUser));
			model.addAttribute("displayCart", "true");

		}
		log.debug("Ending of the method myCart");
		return "/home";
			
	}
	/*-----------------------------------------------------------------------------------------------------------------------------*/
	
	@RequestMapping("/remove_all")
	public ModelAndView showlastPage()
	{

		log.debug("This is ***************lastPage");
		
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		
		log.info("the logged in ********USER ID***********"+ loggedInUserid );
		
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}
		
		log.info("the logged in ********USER ID***********"+ loggedInUserid );
		
		List<MyCart> cartlist = cartDAO.list(loggedInUserid);
		
		int catsize = cartDAO.list(loggedInUserid).size();
		
		log.info("the ****SIZE IS******"+catsize);
	
		for(MyCart listall : cartlist)
		{
			
			myCart.setId(listall.getId());;
			
			cartDAO.deleteNow(myCart);
			
			log.info("****THE CATSIZE**** "+catsize);
		}
		
		ModelAndView mv = new ModelAndView("redirect:/myCart");
		//mv.addObject("displayCart", "true");
		
		log.debug("This is end ************of lastpage");
		return mv;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------------*/


	@RequestMapping("/remove_all_now")
	public ModelAndView checkOut()
	{

		log.debug("This is ***************lastPage");
		
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		
		log.info("the logged in ********USER ID***********"+ loggedInUserid );
		
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}
		
		log.info("the logged in ********USER ID***********"+ loggedInUserid );
		
		List<MyCart> cartlist = cartDAO.list(loggedInUserid);
		
		int catsize = cartDAO.list(loggedInUserid).size();
		
		log.info("the ****SIZE IS******"+catsize);
	
		for(MyCart listall : cartlist)
		{
			
			myCart.setId(listall.getId());;
			
			cartDAO.deleteNow(myCart);
			
			log.info("****THE CATSIZE**** "+catsize);
		}
		
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("checkout", true);
		
		log.debug("This is end ************of lastpage");
		return mv;
	}
	
	
	
	/*-----------------------------------------------------------------------------------------------------------------------------*/
	
	// For add and update myCart both
	@RequestMapping(value = "myCart/add/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id) {
		log.debug("Starting of the method addToCart" + id);
		// get the product based on product id
		Product product = productDAO.getProductByID(id);
		myCart.setPrice(product.getPrice());
		myCart.setProduct_name(product.getName());

		String loggedInUser = (String) session.getAttribute("loggedInUser");
		if (loggedInUser == null) {

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUser = auth.getName();
		}
		// myCart.setId(11l);
		myCart.setQuantity("1");
		myCart.setUser_id(loggedInUser);
		// It is not required if you given default value while creating the
		// table
		myCart.setStatus("N"); // Status is New. Once it is dispatched, we can
								// changed to 'D'

		// To get sequence number, you can do programmatically in DAOImpl
		// myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		cartDAO.save(myCart);
		// return "redirect:/views/home.jsp";

		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("successMessage", " Successfuly add the product to myCart");
		log.debug("Ending of the method addToCart");
		return mv;

	}
	@GetMapping("/addaddress")
	public ModelAndView addAddress() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("addaddress", true);
		return mv;
	}
	
	

	@RequestMapping(value = "manage_cart_delete/{id}")
	public ModelAndView deleteproduct(@PathVariable("id") String id, Model model)

	{
		log.debug(" Starting of the method deleteproduct");

		boolean flag = cartDAO.delete(id);
		/*String msg = "Succesfully done Operation";

		if (flag == false) {
			msg = "The delete operation could not be done";
		}
		model.addAttribute("msg", msg);*/
		ModelAndView mv = new ModelAndView("redirect:/myCart");

		log.debug(" End of the method deleteProducts");
		return mv;

	}

}
