package com.me.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.spring.dao.BuyerUserDAO;
import com.me.spring.dao.SellerUserDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.BuyerUser;
import com.me.spring.pojo.SellerUser;

@Controller
public class AJAXController {

	public AJAXController() {
		
	}
	
	@RequestMapping(value="/getbuyer.htm",method = RequestMethod.POST) //check buyer username
	public ModelAndView getBuyer(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException,JSONException {
		BuyerUserDAO userdao = new BuyerUserDAO();
		String username = request.getParameter("name");
		PrintWriter out = response.getWriter();
		BuyerUser buyerUser = (BuyerUser) userdao.getBuyer(username);
		
		if(buyerUser != null){
			JSONObject obj = new JSONObject();
			obj.put("message","Username already exists");
			out.println(obj);
		}else{
			 out.println("Username is available");
		}
       
		return null;
	}
	
	@RequestMapping(value="/getseller.htm",method = RequestMethod.POST)//check seller username
	public ModelAndView getSeller(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException,JSONException {
		SellerUserDAO userdao = new SellerUserDAO();
		String username = request.getParameter("name");
		PrintWriter out = response.getWriter();
		SellerUser sellerUser = (SellerUser) userdao.getSeller(username);
		
		if(sellerUser != null){
			JSONObject obj = new JSONObject();
			obj.put("message","Username already exists");
			out.println(obj);
		}else{
			 out.println("Username is available");
		}
       
		return null;
	}

}
