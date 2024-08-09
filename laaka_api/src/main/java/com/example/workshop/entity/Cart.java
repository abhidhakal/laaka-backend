package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_seq_gen", sequenceName = "cart_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cart_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}