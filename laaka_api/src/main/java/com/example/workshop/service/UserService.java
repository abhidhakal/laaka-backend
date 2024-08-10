package com.example.workshop.service;

import java.util.List;
import com.example.workshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);

    UserDetails findByEmail(String email) throws UsernameNotFoundException;
}
