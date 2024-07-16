package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shoes")
public class Shoes {
    @Id
    @SequenceGenerator(name = "shoes_seq_gen", sequenceName = "shoes_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shoes_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer shoeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brandName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "image", nullable = false)
    private String imageUrl;
}
