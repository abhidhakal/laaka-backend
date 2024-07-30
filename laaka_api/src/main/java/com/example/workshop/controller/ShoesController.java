package com.example.workshop.controller;

import com.example.workshop.entity.Brand;
import com.example.workshop.entity.Shoes;
import com.example.workshop.pojo.ShoesPojo;
import com.example.workshop.repository.BrandRepository;
import com.example.workshop.service.ShoesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/shoes")
@CrossOrigin(origins = "http://localhost:5173")
public class ShoesController {

    @Autowired
    private ShoesService shoesService;

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public List<Shoes> getAllShoes() {
        return shoesService.getAllShoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shoes> getShoesById(@PathVariable Integer id) {
        return shoesService.getShoesById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createShoes(@ModelAttribute ShoesPojo shoesPojo) {
        try {
            String imageUrl = null;
            if (shoesPojo.getImage() != null && !shoesPojo.getImage().isEmpty()) {
                imageUrl = saveImage(shoesPojo.getImage());
            }

            Shoes shoe = new Shoes();
            shoe.setName(shoesPojo.getName());
            shoe.setCategory(shoesPojo.getCategory());
            shoe.setPrice(shoesPojo.getPrice());
            shoe.setStock(shoesPojo.getStock());
            shoe.setImageUrl(imageUrl);
            shoe.setTrending(shoesPojo.getTrending());

            // Find the brand by name
            Brand brand = brandRepository.findByBrandName(shoesPojo.getBrandName())
                    .orElseThrow(() -> new IllegalArgumentException("Brand not found: " + shoesPojo.getBrandName()));
            shoe.setBrand(brand);

            Shoes createdShoe = shoesService.createShoes(shoe);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdShoe);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving image: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating shoe: " + e.getMessage());
        }
    }

    @Value("${image.upload.dir}")
    private String uploadDir;

    private String saveImage(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoes> updateShoes(@PathVariable Integer id, @RequestBody Shoes shoesDetails) {
        Shoes updatedShoe = shoesService.updateShoes(id, shoesDetails);
        return ResponseEntity.ok(updatedShoe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoes(@PathVariable Integer id) {
        shoesService.deleteShoes(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/trending")
    public List<Shoes> getTrendingShoes() {
        return shoesService.getTrendingShoes();
    }

    @PutMapping("/{id}/trending")
    public ResponseEntity<Void> setTrending(@PathVariable Integer id, @RequestParam Boolean trending) {
        shoesService.setTrending(id, trending);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{category}")
    public List<Shoes> getShoesByCategory(@PathVariable String category) {
        return shoesService.getShoesByCategory(category);
    }


}

