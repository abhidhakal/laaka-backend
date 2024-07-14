package com.example.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workshop.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
