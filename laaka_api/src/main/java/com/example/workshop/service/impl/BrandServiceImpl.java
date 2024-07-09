package com.example.workshop.service.impl;

import com.example.workshop.entity.Brand;
import com.example.workshop.entity.User;
import com.example.workshop.pojo.BrandPojo;
import com.example.workshop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    @Override
    public void saveData(BrandPojo brandPojo) {
        Brand brand = new Brand();

        brand.setBrandName(brandPojo.getBrandName());
        brand.setBrandId(brandPojo.getBrandId());
    }

    @Override
    public List<User> getDataById(int id) {
        return List.of();
    }

    @Override
    public Brand deleteBrandById(int id) {
        return null;

    }
}
