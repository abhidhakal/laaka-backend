package com.example.workshop.service;

import com.example.workshop.entity.Shoes;

import java.util.List;
import java.util.Optional;

public interface ShoesService {
    List<Shoes> getAllShoes();
    Optional<Shoes> getShoesById(Integer id);
    Shoes createShoes(Shoes shoes);
    Shoes updateShoes(Integer id, Shoes shoesDetails);
    void deleteShoes(Integer id);
}
