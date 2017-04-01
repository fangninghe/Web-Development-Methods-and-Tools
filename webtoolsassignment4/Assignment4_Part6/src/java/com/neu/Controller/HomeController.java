/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Alex
 */
public class HomeController implements Controller {

    public HomeController() {
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
        String action = hsr.getParameter("action");
        if (action.equalsIgnoreCase("showform")) {
            String showform = hsr.getParameter("formname");
            mv.addObject("task", "task");
            mv.addObject("formname", showform);
            mv.setViewName("index");
        }
        return mv;
    }

}
