package com.example.workshop.pojo;

import com.example.workshop.entity.Order;
import com.example.workshop.entity.Shoes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPojo {

    private Integer orderItemId;
    private Order order;
    private Shoes shoes;
    private Integer quantity;
    private Double price;

}
