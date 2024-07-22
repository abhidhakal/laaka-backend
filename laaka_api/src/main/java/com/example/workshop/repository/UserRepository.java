package com.example.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workshop.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailOrUsername(String email, String username);
}
