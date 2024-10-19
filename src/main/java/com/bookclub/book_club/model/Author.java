package com.bookclub.book_club.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "author_book",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}
