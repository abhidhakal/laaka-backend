package com.example.workshop.service.impl;

import com.example.workshop.entity.Order;
import com.example.workshop.entity.User;
import com.example.workshop.pojo.OrderPojo;
import com.example.workshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveData(OrderPojo orderPojo) {
        Order order = new Order();

        order.setOrderId(orderPojo.getOrderId());
        order.setOrderDate(orderPojo.getOrderDate());
        order.setOrderStatus(orderPojo.getOrderStatus());
        order.setOrderItems(orderPojo.getOrderItems());
        order.setTotalPrice(orderPojo.getTotalPrice());
        order.setUser(orderPojo.getUser());
    }

    @Override
    public List<Order> getDataById(int id) {
        return List.of();
    }

    @Override
    public Order deleteOrderById(int id) {
        return null;
    }
}
