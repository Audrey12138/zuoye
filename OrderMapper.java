package com.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.beans.Order;

@Mapper
public interface OrderMapper {
    List<Order> selectAllOrders();
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrderByOrderNumber(Integer orderNumber);
    Order selectOrderByOrderNumber(Integer orderNumber);
}






