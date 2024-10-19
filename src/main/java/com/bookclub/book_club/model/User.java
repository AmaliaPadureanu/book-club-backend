package com.bookclub.book_club.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
