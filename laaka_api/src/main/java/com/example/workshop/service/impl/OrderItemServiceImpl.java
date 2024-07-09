package com.example.workshop.service.impl;

import com.example.workshop.entity.OrderItem;
import com.example.workshop.pojo.OrderItemPojo;
import com.example.workshop.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public void saveData(OrderItemPojo orderItemPojo) {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItemId(orderItemPojo.getOrderItemId());
        orderItem.setOrder(orderItemPojo.getOrder());
        orderItem.setShoe(orderItemPojo.getShoes());
        orderItem.setQuantity(orderItemPojo.getQuantity());
        orderItem.setPrice(orderItemPojo.getPrice());

    }

    @Override
    public List<OrderItem> getDataById(int id) {
        return List.of();
    }

    @Override
    public OrderItem deleteOrderItemById(int id) {
        return null;
    }
}
