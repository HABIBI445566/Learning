package com.zahimuslim.Spring_boot_learning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    //Check about this, what does this do
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    //max length will be 60
    @Column(length = 60)
    private String password;
    private String role;
    private Boolean enabled = false;

}
