package com.example.workshop.service;

import com.example.workshop.entity.Brand;
import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> getAllBrands();
    Optional<Brand> getBrandById(Integer id);
    Brand createBrand(Brand brand);
    Brand updateBrand(Integer id, Brand brandDetails);
    void deleteBrand(Integer id);
}
