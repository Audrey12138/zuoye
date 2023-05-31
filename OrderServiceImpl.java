	package com.serviceImpl;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	import com.mapper.OrderMapper;
	import com.beans.Order;
	import com.service.OrderService;

	@Service
	@Transactional(rollbackFor = Exception.class)
	public class OrderServiceImpl implements OrderService {

	    @Autowired
	    private OrderMapper orderMapper;

	    @Override
	    public List<Order> getOrders() {
	        return orderMapper.selectAllOrders();
	    }

	    @Override
	    public void saveOrder(Order order) {
	        orderMapper.addOrder(order);
	    }

	    @Override
	    public void updateOrder(Order order) {
	        orderMapper.updateOrder(order);
	    }

	    @Override
	    public void deleteOrder(Integer orderNumber) {
	        orderMapper.deleteOrderByOrderNumber(orderNumber);
	    }

	    @Override
	    public Order getOrderByOrderNumber(Integer orderNumber) {
	        return orderMapper.selectOrderByOrderNumber(orderNumber);
	    }
	}


