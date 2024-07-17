package com.example.workshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

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

    @NotBlank(message = "Name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Category is required")
    @Column(name = "type", nullable = false)
    private String category;

    @NotNull(message = "Brand is required")
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull(message = "Stock is required")
    @Positive(message = "Stock must be positive")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "image", nullable = true)
    private String imageUrl;

    @Column(name = "trending")
    private Boolean trending;
}