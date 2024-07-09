package com.example.workshop.controller;

import com.example.workshop.entity.Brand;
import com.example.workshop.entity.User;
import com.example.workshop.pojo.BrandPojo;
import com.example.workshop.service.BrandService;
import com.example.workshop.shared_pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Brand")
@RequiredArgsConstructor

public class BrandController {

    private final BrandService brandService;

    @PostMapping("/save")
    public void save(@RequestBody BrandPojo brandPojo){
        this.brandService.saveData(brandPojo);
    }

    @GetMapping("/id")
    public GlobalApiResponse getUserById(@PathVariable int id){
        return GlobalApiResponse.<List<User>>builder().
                data(this.brandService.getDataById(id))
                .StatusCode(200)
                .message("Data has been successfully retrieved")
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse deleteBrandById(@PathVariable int id) {
        Brand deletedBrand = brandService.deleteBrandById(id);
        return GlobalApiResponse.<Brand>builder()
                .data(deletedBrand)
                .StatusCode(200)
                .message("User has been successfully deleted")
                .build();
    }
    
}
