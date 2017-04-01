package com.me.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.me.spring.exception.AdException;
import com.me.spring.pojo.BuyerUser;

public class BuyerUserDAO extends DAO {

	public BuyerUserDAO() {

	}

	public BuyerUser getBuyer(String username, String password)  { //login
		Criteria cr = getSession().createCriteria(BuyerUser.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		BuyerUser user = (BuyerUser) cr.uniqueResult();
		return user;
	}

	public BuyerUser getBuyer(String username){ //get user by username
		Criteria cr = getSession().createCriteria(BuyerUser.class);
		cr.add(Restrictions.eq("username", username));
		BuyerUser user = (BuyerUser) cr.uniqueResult();
		return user;
	}

	public List getBuyer() throws AdException { //get buyer list
		Criteria cr = getSession().createCriteria(BuyerUser.class);
		cr.add(Restrictions.ge("id", 1));
		cr.addOrder(Order.asc("id"));
		return cr.list();
	}

	public BuyerUser create(BuyerUser buyerUser) throws AdException {//create user
		try {
			begin();
			System.out.println("inside DAO");
			// getSession().saveOrUpdate(buyerUser);
			getSession().merge(buyerUser);
			commit();
			return buyerUser;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(BuyerUser user) throws AdException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete user " + user.getUsername(), e);
		}
	}

}
