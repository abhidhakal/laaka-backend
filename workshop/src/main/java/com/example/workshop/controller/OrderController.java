package com.example.workshop.controller;

import com.example.workshop.entity.Order;
import com.example.workshop.entity.User;
import com.example.workshop.pojo.OrderPojo;
import com.example.workshop.pojo.UserPojo;
import com.example.workshop.service.OrderService;
import com.example.workshop.shared_pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public void save(@RequestBody OrderPojo orderPojo){
        this.orderService.saveData(orderPojo);
    }

    @GetMapping("/id")
    public GlobalApiResponse getOrderById(@PathVariable int id){
        return GlobalApiResponse.<List<Order>>builder().
                data(this.orderService.getDataById(id))
                .StatusCode(200)
                .message("Data has been successfully retrieved")
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse deleteOrderById(@PathVariable int id) {
        Order deletedOrder = orderService.deleteOrderById(id);
        return GlobalApiResponse.<Order>builder()
                .data(deletedOrder)
                .StatusCode(200)
                .message("Order has been successfully deleted")
                .build();
    }
}
