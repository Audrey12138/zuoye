package com.service;
import java.util.List;
import com.beans.Order;
public interface OrderService {
	
	    List<Order> getOrders();
	    void saveOrder(Order order);
	    void updateOrder(Order order);
	    void deleteOrder(Integer orderNumber);
	    Order getOrderByOrderNumber(Integer orderNumber);
	    
	}

