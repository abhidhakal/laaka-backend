package com.example.workshop.pojo;

import com.example.workshop.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoesPojo {

    private Integer shoeId;
    private String name;
    private String category;
    private Brand brandName;
    private Integer price;
    private Integer stock;
    private String imageUrl;

}
