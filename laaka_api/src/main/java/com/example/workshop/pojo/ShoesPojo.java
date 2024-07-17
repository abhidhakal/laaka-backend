package com.example.workshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoesPojo {

    private Integer shoeId;
    private String name;
    private String category;
    private String brandName;
    private Double price;
    private Integer stock;
    private MultipartFile image;
    private Boolean trending;
    private String imageUrl;
}
