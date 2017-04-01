package com.me.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.me.spring.exception.AdException;

import com.me.spring.pojo.SellerUser;


public class SellerUserDAO extends DAO{

	public SellerUserDAO() {
		
	}
	
	public SellerUser getSeller(String username, String password){
		Criteria cr = getSession().createCriteria(SellerUser.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		SellerUser user = (SellerUser) cr.uniqueResult();
		return user;
    }
	
	public SellerUser getSeller(String username){
		Criteria cr = getSession().createCriteria(SellerUser.class);
		cr.add(Restrictions.eq("username", username));
		SellerUser user = (SellerUser)cr.uniqueResult();
		return user;
	}
	
	public List getSeller(){
		Criteria cr = getSession().createCriteria(SellerUser.class);
		cr.add(Restrictions.ge("id", 1));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}

    public SellerUser create(SellerUser sellerUser)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            //getSession().saveOrUpdate(getSession().merge(sellerUser));
            getSession().merge(sellerUser);
            commit();
            return sellerUser;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(SellerUser user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getName(), e);
        }
    }

}
