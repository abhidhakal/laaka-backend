package com.example.workshop.service;

import com.example.workshop.entity.Shoes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ShoesService {
    List<Shoes> getAllShoes();
    Optional<Shoes> getShoesById(Integer id);
    Shoes createShoes(Shoes shoes) throws IOException;
    Shoes updateShoes(Integer id, Shoes shoesDetails);
    void deleteShoes(Integer id);
    List<Shoes> getTrendingShoes();
    void setTrending(Integer id, Boolean trending);
}
