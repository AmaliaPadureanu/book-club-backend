package com.bookclub.book_club.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String content;
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
