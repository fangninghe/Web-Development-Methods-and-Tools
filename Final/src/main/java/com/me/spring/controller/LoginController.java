package com.me.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.BuyerUserDAO;
import com.me.spring.dao.SellerUserDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.BuyerUser;
import com.me.spring.pojo.SellerUser;

@Controller
public class LoginController {

	public LoginController() {
		
	}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public String getUser(HttpServletRequest request, HttpServletResponse response) throws AdException {
		HttpSession session = request.getSession();
		String role = request.getParameter("role");
		
		if(role.equalsIgnoreCase("buyer")){
			BuyerUserDAO userdao = new BuyerUserDAO();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			BuyerUser buyerUser = (BuyerUser) userdao.getBuyer(username,password);
			if(buyerUser == null){
				request.setAttribute("none", "none");
			}else{
				session.setAttribute("buyerUser", buyerUser);
//				Cookie usernamecookie = new Cookie("username",request.getParameter("username"));
//				Cookie passwordcookie = new Cookie("password",request.getParameter("password"));
//				response.addCookie(usernamecookie);
//				response.addCookie(passwordcookie);
			}
			return "buyerPage";
		}else {//if(role.equalsIgnoreCase("seller")){
			SellerUserDAO userdao = new SellerUserDAO();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			SellerUser sellerUser = (SellerUser) userdao.getSeller(username,password);
			if(sellerUser == null){
				request.setAttribute("none", "none");
			}else{
				session.setAttribute("sellerUser", sellerUser);
//				Cookie usernamecookie = new Cookie("username",request.getParameter("username"));
//				Cookie passwordcookie = new Cookie("password",request.getParameter("password"));
//				response.addCookie(usernamecookie);
//				response.addCookie(passwordcookie);
			}
			return "sellerPage";
		}
		
	}
	
	@RequestMapping(value="/logout.htm",method = RequestMethod.POST)
	public String logOut(HttpServletRequest request, HttpServletResponse response) throws AdException {
		HttpSession session = request.getSession();
		session.invalidate();
		return "home";
	}

}
