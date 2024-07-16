package com.example.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workshop.entity.Brand;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
