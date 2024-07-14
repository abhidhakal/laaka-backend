package com.example.workshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.workshop.entity.Brand;
import com.example.workshop.repository.BrandRepository;
import com.example.workshop.service.BrandService;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> getBrandById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Integer id, Brand brandDetails) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));

        brand.setBrandName(brandDetails.getBrandName());

        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }
}
