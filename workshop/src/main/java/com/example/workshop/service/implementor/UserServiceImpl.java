package com.example.workshop.service.implementor;

import com.example.workshop.entity.User;
import com.example.workshop.pojo.UserPojo;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveData(UserPojo userPojo) {
        User user = new User();

        user.setId(userPojo.getId());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());
        user.setContact(userPojo.getContact());
        user.setEmail(userPojo.getEmail());
        user.setDob(userPojo.getDob());

        userRepository.save(user);
    }
}
