package com.example.workshop.controller;

import com.example.workshop.entity.User;
import com.example.workshop.pojo.UserPojo;
import com.example.workshop.service.UserService;
import com.example.workshop.shared_pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserPojo userPojo){
        this.userService.saveData(userPojo);
    }

    @GetMapping("/id")
    public GlobalApiResponse getUserById(@PathVariable int id){
        return GlobalApiResponse.<List<User>>builder().
                data(this.userService.getDataById(id))
                .StatusCode(200)
                .message("Data has been successfully retrieved")
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse deleteUserById(@PathVariable int id) {
        User deletedUser = userService.deleteDataById(id);
        return GlobalApiResponse.<User>builder()
                .data(deletedUser)
                .StatusCode(200)
                .message("User has been successfully deleted")
                .build();
    }
}
