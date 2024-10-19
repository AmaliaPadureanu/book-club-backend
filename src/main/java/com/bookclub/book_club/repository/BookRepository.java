package com.bookclub.book_club.repository;

import com.bookclub.book_club.model.Author;
import com.bookclub.book_club.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String titlePart);
    boolean existsByTitleAndAuthors(String title, List<Author> authors);
}
