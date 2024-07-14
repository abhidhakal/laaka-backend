package com.example.workshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.workshop.entity.Order;
import com.example.workshop.repository.OrderRepository;
import com.example.workshop.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Integer id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderDate(orderDetails.getOrderDate());
        order.setUser(orderDetails.getUser());
        order.setOrderStatus(orderDetails.getOrderStatus());
        order.setTotalPrice(orderDetails.getTotalPrice());
        order.setOrderItems(orderDetails.getOrderItems());

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
