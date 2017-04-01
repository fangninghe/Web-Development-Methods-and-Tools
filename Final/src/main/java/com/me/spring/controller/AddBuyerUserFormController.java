package com.me.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.BuyerUserDAO;
import com.me.spring.dao.MessageDAO;
import com.me.spring.dao.SellerUserDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.BuyerUser;
import com.me.spring.pojo.Message;
import com.me.spring.pojo.SellerUser;

@Controller
public class AddBuyerUserFormController {
	@Autowired
	@Qualifier("buyerUserValidator")
	BuyerUserValidator buyerUserValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(buyerUserValidator);
	}
	
	@RequestMapping(value = "/addbuyeruser.htm", method = RequestMethod.POST)//save buyeruser
	protected String doSubmitAction(@ModelAttribute("buyerUser") BuyerUser buyerUser, BindingResult result, HttpServletRequest request)
			throws Exception {
		buyerUserValidator.validate(buyerUser, result);
		if (result.hasErrors()) {
			return "addBuyerForm";
		}
		try {
			BuyerUserDAO buyerUserDao = new BuyerUserDAO();
			buyerUserDao.create(buyerUser);
			HttpSession session = request.getSession();
			session.setAttribute("buyerUser", buyerUser);
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedBuyer";
	}
	
	@RequestMapping(value="/addbuyeruser.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("buyerUser") BuyerUser buyerUser, BindingResult result) {

		return "addBuyerForm";
	}
	
	
	@RequestMapping(value="/getuserprofile.htm",method = RequestMethod.GET)//update personal file
	public String getUserProfile(HttpServletRequest request)throws AdException{
		request.setAttribute("showuser", "showuser");
		return "buyerPage";
	}
	
	@RequestMapping(value="/updatebuyeruser.htm", method = RequestMethod.POST)
	public String updateProfiel(HttpServletRequest request)throws AdException{
		HttpSession session = request.getSession();
		BuyerUser user = (BuyerUser) session.getAttribute("buyerUser");
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhoneNumber(request.getParameter("phonenumber"));
		BuyerUserDAO userDAO = new BuyerUserDAO();
		userDAO.create(user);
		request.setAttribute("win", "win");
		return "buyerPage";
	}
	
	@RequestMapping(value="/buyersendmessage.htm", method = RequestMethod.GET)//buyer send message
	public String buyerMessage(HttpServletRequest request)throws AdException{
		String action = request.getParameter("action");
		if(action.equals("seeseller") || action.equals("goback")){
			
			String username = request.getParameter("username");
			SellerUserDAO sellerUserDao = new SellerUserDAO();
			SellerUser sellerUser = sellerUserDao.getSeller(username);
			request.setAttribute("leavemessage", "leavemessage");
			request.setAttribute("sellerUser", sellerUser);
		}else if(action.equals("checkout")){                              //buyer checkout
			String username = request.getParameter("username");
			int day = Integer.parseInt(request.getParameter("day"));
			SellerUserDAO sellerUserDao = new SellerUserDAO();
			SellerUser sellerUser = sellerUserDao.getSeller(username);
			int total = sellerUser.getTotal();
			total += Integer.parseInt(sellerUser.getPrice())*day;
			sellerUser.setTotal(total);
			sellerUserDao.create(sellerUser);
			request.setAttribute("sellerUser", sellerUser);
			request.setAttribute("checkoutyes", "checkoutyes");
			
			}else{
			HttpSession session = request.getSession();
			BuyerUser buyerUser = (BuyerUser) session.getAttribute("buyerUser");
			
			String username = request.getParameter("username");
			SellerUserDAO sellerUserDao = new SellerUserDAO();
			SellerUser sellerUser = sellerUserDao.getSeller(username);
			String mes = request.getParameter("message");
			
			Message message = new Message();
			message.setBuyer(buyerUser);
			message.setMessage(mes);
			message.setSeller(sellerUser);
			
			MessageDAO messageDao = new MessageDAO();
			messageDao.create(message);
//			if(buyerUser==null){
//				request.setAttribute("nobuyer", "nobuyer");
//			}
			request.setAttribute("success", "success");
			request.setAttribute("sellerUser", sellerUser);
		}
		if(action.equals("gobackhome")){
			return "buyerPage";
		}
		return "leaveMessage";
	}

}
