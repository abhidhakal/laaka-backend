package com.example.workshop.service;

import com.example.workshop.entity.OrderItem;
import com.example.workshop.pojo.OrderItemPojo;

import java.util.List;

public interface OrderItemService {
    void saveData(OrderItemPojo orderItemPojo);
    List<OrderItem> getDataById(int id);
    OrderItem deleteOrderItemById(int id);
}
