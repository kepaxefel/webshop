package com.shop.managers;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.domains.Order;

@Repository
@Transactional
public class OrdersManager implements OrdersManagerInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}

	@Override
	public List<Order> getOrders() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Order> orders = session.createCriteria(Order.class).list();
		return orders;
	}
	
	@Override
	public void deleteOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, id);				
		session.delete(order);					
	}
}
