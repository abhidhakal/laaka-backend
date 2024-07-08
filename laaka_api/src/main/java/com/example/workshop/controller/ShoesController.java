package com.example.workshop.controller;

import com.example.workshop.pojo.ShoesPojo;
import com.example.workshop.service.ShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Shoes")
@RequiredArgsConstructor
public class ShoesController {
    private final ShoesService shoesService;

    @PostMapping("/save")
    public void save(@RequestBody ShoesPojo shoesPojo){
        this.shoesService.saveData(shoesPojo);
    }
}
