package com.bookclub.book_club.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    private String title;
    private int numberOfPages;
    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    private BigDecimal price;
    private int inventory;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    private Double rating;

    @Enumerated(EnumType.STRING)
    private Language language;

    private LocalDate publicationDate;
}
