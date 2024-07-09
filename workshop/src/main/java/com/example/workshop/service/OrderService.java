package com.example.workshop.service;

import com.example.workshop.entity.Order;
import com.example.workshop.entity.User;
import com.example.workshop.pojo.OrderPojo;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {
    void saveData(OrderPojo orderPojo);
    List<Order> getDataById(int id);
    Order deleteOrderById(int id);

}
