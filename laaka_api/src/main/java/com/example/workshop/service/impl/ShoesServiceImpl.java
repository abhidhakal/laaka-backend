package com.example.workshop.service.impl;

import com.example.workshop.entity.Shoes;
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
        return shoesRepository.save(shoes);
    }

    @Override
    public Shoes updateShoes(Integer id, Shoes shoesDetails) {
        Shoes shoes = shoesRepository.findById(id).orElseThrow(() -> new RuntimeException("Shoes not found"));
        shoes.setName(shoesDetails.getName());
        shoes.setCategory(shoesDetails.getCategory());
        shoes.setBrandName(shoesDetails.getBrandName());
        shoes.setPrice(shoesDetails.getPrice());
        shoes.setStock(shoesDetails.getStock());
        shoes.setImageUrl(shoesDetails.getImageUrl());
        return shoesRepository.save(shoes);
    }

    @Override
    public void deleteShoes(Integer id) {
        shoesRepository.deleteById(id);
    }
}
