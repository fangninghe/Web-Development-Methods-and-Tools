package com.me.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.spring.dao.SellerUserDAO;
import com.me.spring.exception.AdException;
import com.me.spring.pojo.SellerUser;

@Controller
public class FiterSellerController {

	public FiterSellerController() {
		
	}
	
	@RequestMapping(value="/filter.htm",method = RequestMethod.POST)
	public String filterSellerUser(HttpServletRequest request, HttpServletResponse response) throws AdException{
		List<SellerUser> sellerList = new ArrayList();
	    SellerUserDAO userDao = new SellerUserDAO();
	    sellerList = userDao.getSeller();
	    String gender = null;
	    gender = request.getParameter("gender");
	    String category = null;
	    category = request.getParameter("category");
	    List<SellerUser> sellerList1 = sellerList;
	   
	    if(gender != null){
	    	if(gender.equals("F")){
	    		
		    	for(int i=0; i<sellerList1.size();i++){
		    		//System.out.println("Here:!!!" + sellerList.get(i).getGender());
		    		if(sellerList1.get(i).getGender().equals("M")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
		    	request.setAttribute("sellerListF", sellerList1);
			    request.setAttribute("sellerF", "sellerF");
			   //System.out.print("Here:!!!!!!!!!!!!" + sellerList1.size());
		    }
		    
		    if(gender.equals("M")){
		    	for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getGender().equals("F")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
		    	request.setAttribute("sellerListM", sellerList1);
			    request.setAttribute("sellerM", "sellerM");
		    }
	    }
	    
	    
	    if(category != null){
	    	if(category.equals("Parent")){
	    		for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getCatagory().equals("Fellow")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
		    	request.setAttribute("sellerListP", sellerList1);
			    request.setAttribute("sellerP", "sellerP");
		    }
		    
		    if(category.equals("Fellow")){
		    	for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getCatagory().equals("Parent")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
		    	request.setAttribute("sellerListFe", sellerList1);
			    request.setAttribute("sellerFe", "sellerFe");
		    }
	    }
	    
	    
	    
	    if(gender != null && category != null){
	    	if(gender.equals("F") && category.equals("Parent")){
	    		for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getGender().equals("M")||sellerList1.get(i).getCatagory().equals("Fellow")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
	    		request.setAttribute("sellerListFP", sellerList1);
			    request.setAttribute("sellerFP", "sellerFP");
	    	}
	    	
	    	if(gender.equals("F") && category.equals("Fellow")){
	    		for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getGender().equals("M")||sellerList1.get(i).getCatagory().equals("Parent")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
	    		request.setAttribute("sellerListFF", sellerList1);
			    request.setAttribute("sellerFF", "sellerFF");
	    	}
	    	
	    	if(gender.equals("M") && category.equals("Parent")){
	    		for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getGender().equals("F")||sellerList1.get(i).getCatagory().equals("Fellow")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
	    		request.setAttribute("sellerListMP", sellerList1);
			    request.setAttribute("sellerMP", "sellerMP");
	    	}
	    	
	    	if(gender.equals("M") && category.equals("Fellow")){
	    		for(int i=0; i<sellerList1.size();i++){
		    		if(sellerList1.get(i).getGender().equals("F")||sellerList1.get(i).getCatagory().equals("Parent")){
		    			sellerList1.remove(sellerList1.get(i));
		    		}
		    	}
	    		request.setAttribute("sellerListMF", sellerList1);
			    request.setAttribute("sellerMF", "sellerMF");
	    	}
	    	
	    }
	    
	    
		return "buyerPage";
		
	}

}
