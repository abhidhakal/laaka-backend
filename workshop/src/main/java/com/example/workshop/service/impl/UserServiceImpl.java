package com.example.workshop.service.impl;

import com.example.workshop.entity.User;
import com.example.workshop.exception.ResourceNotFoundException;
import com.example.workshop.pojo.UserPojo;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveData(UserPojo userPojo) {
        User user = new User();

        user.setUserId(userPojo.getUserId());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setContact(userPojo.getContact());
        user.setEmail(userPojo.getEmail());

        userRepository.save(user);
    }

    @Override
    public List<User> getDataById(int id) {
        return List.of();
    }

    @Override
    public User deleteDataById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
        return user;
    }
}
