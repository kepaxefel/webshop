 package com.shop.managers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.domains.User;

@Repository
@Transactional
public class UsersManager implements UsersManagerInterface{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		List <User> users = null;
		Session session = sessionFactory.getCurrentSession();
		users = session.createCriteria(User.class).list();		
		return users;
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);				
		session.delete(user);			
	}
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.getCurrentSession();
		users = session.createCriteria(User.class).add(Restrictions.like("login", username)).list();
			
		return users.size() > 0 ? users.get(0) : null;
	}
	
}