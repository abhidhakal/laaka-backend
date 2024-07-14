package com.example.workshop.service;

import com.example.workshop.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Integer id);
    Order createOrder(Order order);
    Order updateOrder(Integer id, Order orderDetails);
    void deleteOrder(Integer id);
}
