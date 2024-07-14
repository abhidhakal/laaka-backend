package com.example.workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.workshop.entity.Shoes;
import com.example.workshop.service.ShoesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shoes")
@RequiredArgsConstructor
public class ShoesController {
    private ShoesService shoesService;

    @GetMapping
    public List<Shoes> getAllShoes() {
        return shoesService.getAllShoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shoes> getShoesById(@PathVariable Integer id) {
        Optional<Shoes> shoes = shoesService.getShoesById(id);
        return shoes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Shoes createShoes(@RequestBody Shoes shoes) {
        return shoesService.createShoes(shoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoes> updateShoes(@PathVariable Integer id, @RequestBody Shoes shoesDetails) {
        return ResponseEntity.ok(shoesService.updateShoes(id, shoesDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoes(@PathVariable Integer id) {
        shoesService.deleteShoes(id);
        return ResponseEntity.noContent().build();
    }
}
