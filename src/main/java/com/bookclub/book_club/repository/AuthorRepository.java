package com.bookclub.book_club.repository;

import com.bookclub.book_club.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select * from author where first_name = :firstName and last_name = :lastName", nativeQuery = true)
    Optional<Author> findByName(String firstName, String lastName);
}
