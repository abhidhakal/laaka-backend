package com.example.workshop.service.impl;

import com.example.workshop.entity.Brand;
import com.example.workshop.entity.Shoes;
import com.example.workshop.repository.BrandRepository;
import com.example.workshop.repository.ShoesRepository;
import com.example.workshop.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoesServiceImpl implements ShoesService {

    @Autowired
    private ShoesRepository shoesRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Shoes> getAllShoes() {
        return shoesRepository.findAll();
    }

    @Override
    public Optional<Shoes> getShoesById(Integer id) {
        return shoesRepository.findById(id);
    }

    @Override
    public Shoes createShoes(Shoes shoes) {
        if (shoes.getBrand() == null || shoes.getBrand().getBrandName() == null || shoes.getBrand().getBrandName().isEmpty()) {
            throw new IllegalArgumentException("Brand and brand name cannot be null or empty when creating shoes");
        }

        String brandName = shoes.getBrand().getBrandName();
        Brand brand = brandRepository.findByBrandName(brandName)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found: " + brandName));

        shoes.setBrand(brand);

        if (shoes.getTrending() == null) {
            shoes.setTrending(false);
        }

        return shoesRepository.save(shoes);
    }

    @Override
    public Shoes updateShoes(Integer id, Shoes shoesDetails) {
        Shoes shoes = shoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoe not found"));

        shoes.setName(shoesDetails.getName());
        shoes.setCategory(shoesDetails.getCategory());
        shoes.setPrice(shoesDetails.getPrice());
        shoes.setStock(shoesDetails.getStock());
        shoes.setTrending(shoesDetails.getTrending());

        if (shoesDetails.getBrand() != null && shoesDetails.getBrand().getBrandName() != null &&
                !shoes.getBrand().getBrandName().equals(shoesDetails.getBrand().getBrandName())) {
            Brand brand = brandRepository.findByBrandName(shoesDetails.getBrand().getBrandName())
                    .orElseThrow(() -> new RuntimeException("Brand not found"));
            shoes.setBrand(brand);
        }

        return shoesRepository.save(shoes);
    }

    @Override
    public void deleteShoes(Integer id) {
        shoesRepository.deleteById(id);
    }

    @Override
    public List<Shoes> getTrendingShoes() {
        return shoesRepository.findByTrending(true);
    }

    @Override
    public void setTrending(Integer id, Boolean trending) {
        Shoes shoes = shoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoe not found"));
        shoes.setTrending(trending);
        shoesRepository.save(shoes);
    }
}