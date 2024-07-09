package com.example.workshop.controller;

import com.example.workshop.entity.Brand;
import com.example.workshop.entity.Order;
import com.example.workshop.entity.OrderItem;
import com.example.workshop.pojo.BrandPojo;
import com.example.workshop.pojo.OrderItemPojo;
import com.example.workshop.service.OrderItemService;
import com.example.workshop.shared_pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping("/save")
    public void save(@RequestBody OrderItemPojo orderItemPojo){
        this.orderItemService.saveData(orderItemPojo);
    }

    @GetMapping("/id")
    public GlobalApiResponse getDataById(@PathVariable int id){
        return GlobalApiResponse.<List<OrderItem>>builder().
                data(this.orderItemService.getDataById(id))
                .StatusCode(200)
                .message("Data has been successfully retrieved")
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse deleteOrderItemById(@PathVariable int id) {
        OrderItem deletedOrderItem = orderItemService.deleteOrderItemById(id);
        return GlobalApiResponse.<OrderItem>builder()
                .data(deletedOrderItem)
                .StatusCode(200)
                .message("User has been successfully deleted")
                .build();
    }
}
