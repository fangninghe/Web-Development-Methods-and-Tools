package com.me.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.BuyerUserDAO;
import com.me.spring.dao.SellerUserDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.BuyerUser;
import com.me.spring.pojo.SellerUser;

@Controller
public class ManageUserController {

	public ManageUserController() {
		
	}
	
	@RequestMapping(value="/manageuser.htm",method = RequestMethod.GET)
	public String getUser(){
		return "manageUser";
	}
	
	@RequestMapping(value="/managebuyeruser.htm",method = RequestMethod.GET)
	public String getBuyerUser(HttpServletRequest request) throws AdException{
		List<BuyerUser> buyerList = new ArrayList();
	    BuyerUserDAO userDao = new BuyerUserDAO();
	    buyerList = userDao.getBuyer();
	    request.setAttribute("buyerList", buyerList);
	    request.setAttribute("buyer", "buyer");
		return "manageUser";
	}
	
	@RequestMapping(value="/manageselleruser.htm",method = RequestMethod.GET)
	public String getSellerUser(HttpServletRequest request, HttpServletResponse response) throws AdException{
		List<SellerUser> sellerList = new ArrayList();
	    SellerUserDAO userDao = new SellerUserDAO();
	    sellerList = userDao.getSeller();
	    request.setAttribute("sellerList", sellerList);
	    request.setAttribute("seller", "seller");
		return "manageUser";
	}

}
