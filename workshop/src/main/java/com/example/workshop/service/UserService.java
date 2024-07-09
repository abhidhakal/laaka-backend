package com.example.workshop.service;

import com.example.workshop.entity.User;
import com.example.workshop.pojo.UserPojo;

import java.util.List;

public interface UserService {
    void saveData(UserPojo userPojo);
    List<User> getDataById(int id);
    User deleteDataById(int id);
}
