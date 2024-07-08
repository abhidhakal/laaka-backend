package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_order_id", columnNames = "id")
})
public class Order {

    @Id
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "order_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer orderId;

    @Column(name = "date", nullable = false)
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "status", nullable = false)
    private String orderStatus;

    @Column(name = "total", nullable = false)
    private double totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

}
