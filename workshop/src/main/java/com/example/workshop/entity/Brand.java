package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @SequenceGenerator(name = "brand_seq_gen", sequenceName = "brand_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "brand_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer brandId;

    @Column(name = "brandName", nullable = false)
    private String brandName;
}
