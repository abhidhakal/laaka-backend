package com.example.workshop.service;

import com.example.workshop.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User userDetails);
    void deleteUser(Integer id);
}
