/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alex
 */
public class BookDao {
    Configuration cfg = new Configuration();
    SessionFactory sf = cfg.configure().buildSessionFactory();
    
    public void addBook(Book book) throws SQLException {
        Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = hibsession.beginTransaction();
            hibsession.saveOrUpdate(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            hibsession.close();
        }

    }
    
    public List<Book> searchUsers(String key, String flag) {
        Session hibsession = sf.openSession();
        Query query = null;
        List<Book> list = new ArrayList<Book>();
        try {
            String hql = "FROM Book book where book." + flag + "= :value";
            query = hibsession.createQuery(hql);
            query.setParameter("value", key);
            list = query.list();
        } catch (HibernateException e) {
        } finally {
            hibsession.close();
        }
        return list;
    }
}
