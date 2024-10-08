package com.example.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.workshop.entity.Brand;
import com.example.workshop.service.BrandService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins = "http://localhost:5173")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Brand>> getBrandById(@PathVariable Integer id) {
        Optional<Brand> brand = brandService.getBrandById(id);
        if (brand != null) {
            return ResponseEntity.ok(brand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Integer id, @RequestBody Brand brandDetails) {
        return ResponseEntity.ok(brandService.updateBrand(id, brandDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Integer id) {
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
