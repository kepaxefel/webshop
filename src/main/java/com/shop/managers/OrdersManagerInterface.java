package com.shop.managers;

import java.util.List;

import com.shop.domains.Order;

public interface OrdersManagerInterface {
	public void addOrder(Order order);
	public List<Order> getOrders();
	public void deleteOrder(int id);
}
