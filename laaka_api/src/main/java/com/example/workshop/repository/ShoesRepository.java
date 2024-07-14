package com.example.workshop.repository;

import com.example.workshop.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Integer> {
}
