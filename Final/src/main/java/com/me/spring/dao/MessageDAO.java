package com.me.spring.dao;

import org.hibernate.HibernateException;

import com.me.spring.exception.AdException;
import com.me.spring.pojo.Message;


public class MessageDAO  extends DAO{

	public MessageDAO(){
		
	}
	
	public Message create(Message message) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			//getSession().saveOrUpdate(getSession().merge(buyerUser));
			getSession().merge(message);
			commit();
			return message;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		} finally {
			close();
		}
	}

}
