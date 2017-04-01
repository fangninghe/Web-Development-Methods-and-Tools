package com.me.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.me.spring.pojo.BuyerUser;
import com.me.spring.pojo.Message;
import com.me.spring.pojo.SellerUser;
import com.me.spring.dao.BuyerUserDAO;
import com.me.spring.dao.MessageDAO;
import com.me.spring.dao.SellerUserDAO;
import com.me.spring.exception.AdException;

@Controller
public class AddSellerUserFormController{
	
	@Autowired
	@Qualifier("sellerUserValidator")
	SellerUserValidator sellerValidator;
	
	@Autowired
    ServletContext context; 

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(sellerValidator);
	}

	@RequestMapping(value = "/addselleruser.htm", method = RequestMethod.POST)//save seller
	protected String doSubmitAction(@ModelAttribute("sellerUser") SellerUser sellerUser, BindingResult result, HttpServletRequest request)
			throws Exception {
		sellerValidator.validate(sellerUser, result);
		if (result.hasErrors()) {
			return "addSellerForm";
		}

		try {
			SellerUserDAO sellerUserDao = new SellerUserDAO();
			sellerUserDao.create(sellerUser);
			HttpSession session = request.getSession();
			session.setAttribute("sellerUser", sellerUser);
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedSeller";
	}
	
	@RequestMapping(value="/addselleruser.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("sellerUser") SellerUser sellerUser, BindingResult result) {

		return "addSellerForm";
	}
	
	@RequestMapping(value="/sellercheckstatus.htm",method = RequestMethod.GET)//check seller
	public String sellerCheckStatus(HttpServletRequest request)throws AdException{
		String username = request.getParameter("username");
		SellerUserDAO userDAO = new SellerUserDAO();
		SellerUser user = userDAO.getSeller(username);
		if(user.getCheckstatus().equals("Initial") || user.getCheckstatus().equals("Block")){
			user.setCheckstatus("Appoved");
		}else{
			user.setCheckstatus("Block");
		}
		userDAO.create(user);
		request.setAttribute("win", "win");
		return "manageUser";
	}
	
	@RequestMapping(value="/browseseller.htm",method = RequestMethod.GET) //browse sellers
	public String getSellerUser(HttpServletRequest request, HttpServletResponse response) throws AdException{
		List<SellerUser> sellerList = new ArrayList();
	    SellerUserDAO userDao = new SellerUserDAO();
	    sellerList = userDao.getSeller();
	    HttpSession session = request.getSession();
	    request.setAttribute("sellerList", sellerList);
	    session.setAttribute("seller", "seller");
	    
		return "buyerPage";
	}
	@RequestMapping(value="/updateselleruser.htm",method = RequestMethod.POST)//update personal profile
	public String updateProfiel(HttpServletRequest request)throws AdException{
		HttpSession session = request.getSession();
		SellerUser user = (SellerUser) session.getAttribute("sellerUser");
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhoneNumber(request.getParameter("phonenumber"));
		user.setAboutMe(request.getParameter("aboutme"));
		user.setAddress(request.getParameter("address"));
		user.setCheckstatus("Initial");
		user.setPrice(request.getParameter("price"));
		SellerUserDAO userDAO = new SellerUserDAO();
		userDAO.create(user);
		request.setAttribute("win", "win");
		return "sellerPage";
	}
	
	@RequestMapping(value="/getselleruserprofile.htm",method = RequestMethod.GET)
	public String getUserProfile(HttpServletRequest request)throws AdException{
		request.setAttribute("showuser", "showuser");
		return "sellerPage";
	}
	
	@RequestMapping(value="/browsemessages.htm",method = RequestMethod.GET)//show seller message list
	public String getMessage(HttpServletRequest request)throws AdException{
		request.setAttribute("showmessage", "showmessage");
		return "sellerPage";
	}
	
	@RequestMapping(value="/availablestatusupdate.htm",method = RequestMethod.GET)//update available
	public String updateAvailable(HttpServletRequest request)throws AdException{
		HttpSession session = request.getSession();
		SellerUser user = (SellerUser)session.getAttribute("sellerUser");
		if(user.getAvailablestatus().equals("Available")){
			user.setAvailablestatus("Occupied");
		}else{
			user.setAvailablestatus("Available");
		}
		
		SellerUserDAO userDao = new SellerUserDAO();
		userDao.create(user);
		request.setAttribute("win", "win");
		return "sellerPage";
	}
	
	@RequestMapping(value="/selleruserreply.htm",method = RequestMethod.GET)//seller send message
	public String sellerMessage(HttpServletRequest request)throws AdException{
		
		String action = request.getParameter("action");
		if(action.equals("reply")){
			request.setAttribute("reply", "reply");
			String username = request.getParameter("username");
			BuyerUserDAO buyerUserDao = new BuyerUserDAO();
			BuyerUser buyerUser = buyerUserDao.getBuyer(username);
			request.setAttribute("leavemessage", "leavemessage");
			request.setAttribute("buyerUser", buyerUser);
		}else{
			HttpSession session = request.getSession();
			SellerUser sellerUser = (SellerUser) session.getAttribute("sellerUser");
			
			String username = request.getParameter("username");
			BuyerUserDAO buyerUserDao = new BuyerUserDAO();
			BuyerUser buyerUser = buyerUserDao.getBuyer(username);
			String mes = request.getParameter("message");
			
			Message message = new Message();
			message.setBuyer(buyerUser);
			message.setMessage(mes);
			message.setSeller(sellerUser);
			
			MessageDAO messageDao = new MessageDAO();
			messageDao.create(message);
			request.setAttribute("success", "success");
		}
		
		return "sellerPage";
	}
	
}
