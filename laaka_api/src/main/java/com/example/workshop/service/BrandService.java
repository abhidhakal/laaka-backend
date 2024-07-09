package com.example.workshop.service;

import com.example.workshop.entity.Brand;
import com.example.workshop.entity.User;
import com.example.workshop.pojo.BrandPojo;

import java.util.List;

public interface BrandService {
    void saveData(BrandPojo brandPojo);
    List<User> getDataById(int id);
    Brand deleteBrandById(int id);
}
