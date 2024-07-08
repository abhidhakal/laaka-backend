package com.example.workshop.service.impl;

import org.springframework.stereotype.Service;

import com.example.workshop.entity.Shoes;
import com.example.workshop.pojo.ShoesPojo;
import com.example.workshop.repository.ShoesRepository;
import com.example.workshop.service.ShoesService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoesServiceImpl implements ShoesService {
    private final ShoesRepository shoesRepository;

    @Override
    public void saveData(ShoesPojo shoesPojo) {

    }
}
