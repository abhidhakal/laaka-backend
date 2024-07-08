package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_user_id", columnNames = "id")
})

public class User {

    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "fname", nullable = false)
    private String fullname;

    @Column(name = "contact")
    private String contact;

    @Column(name = "address", nullable = false)
    private String address;
}
