package com.example.workshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserPojo {

    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String contact;
    private Date address;

}
