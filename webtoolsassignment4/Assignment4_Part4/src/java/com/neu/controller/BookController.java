/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.BookDao;
import com.neu.pojo.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Alex
 */
public class BookController implements Controller {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

//    public BookController() {
//
//    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");
        ModelAndView mv = new ModelAndView();

        // if (action != null) {
        if (action.equalsIgnoreCase("addbooks")) {
            int number = Integer.parseInt(hsr.getParameter("booknumber"));
            session.setAttribute("totalnumber", number);
            for (int i = 1; i <= number; i++) {
                String authors = hsr.getParameter("authors" + String.valueOf(i));
                String isbn = hsr.getParameter("isbn" + String.valueOf(i));
                String title = hsr.getParameter("title" + String.valueOf(i));
                Float price = Float.parseFloat(hsr.getParameter("price" + String.valueOf(i)));
                Book book = new Book();
                book.setAuthors(authors);
                book.setIsbn(isbn);
                book.setPrice(price);
                book.setTitle(title);
                bookDao.addBook(book);
            }
            mv.setViewName("AddSuccess");
        } else if (action.equalsIgnoreCase("return")) {
            mv.setViewName("Welcome");
        } else if (action.equalsIgnoreCase("search")) {
            mv.setViewName("Search");
        } else if (action.equalsIgnoreCase("searchresult")) {
          

            String key = hsr.getParameter("searchbook");
            String searchKey = hsr.getParameter("search");

            List<Book> bookList = bookDao.searchUsers(key, searchKey);
            mv.addObject("searchbook", bookList);
            mv.addObject("keyword", key);
            mv.setViewName("SearchResult");
        }
//        }else{
//            mv.setViewName("Welcome");
//        }
        return mv;
    }

}
