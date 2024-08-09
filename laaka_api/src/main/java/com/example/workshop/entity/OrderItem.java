package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @SequenceGenerator(name = "order_item_seq_gen", sequenceName = "order_item_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "order_item_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "shoe_id")
    private Shoes shoe;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "size", nullable = false)
    private String size;
}
