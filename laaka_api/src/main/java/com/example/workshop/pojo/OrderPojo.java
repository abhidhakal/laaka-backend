package com.example.workshop.pojo;

import com.example.workshop.entity.OrderItem;
import com.example.workshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPojo {

    private Integer orderId;
    private Date orderDate;
    private String orderStatus;
    private double totalPrice;
    private String billingAddress;
    private List<OrderItem> orderItems;
}
