package com.example.workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.workshop.entity.Shoes;
import com.example.workshop.service.ShoesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shoes")
@CrossOrigin(origins = "http://localhost:5173")
public class ShoesController {
    @Autowired
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
    public ResponseEntity<Shoes> createShoes(@RequestBody Shoes shoes) {
        Shoes createdShoe = shoesService.createShoes(shoes);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShoe);
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
