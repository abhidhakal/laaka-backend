package com.example.workshop.service;

import com.example.workshop.entity.OrderItem;
import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    Optional<OrderItem> getOrderItemById(Integer id);
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(Integer id, OrderItem orderItemDetails);
    void deleteOrderItem(Integer id);
}
