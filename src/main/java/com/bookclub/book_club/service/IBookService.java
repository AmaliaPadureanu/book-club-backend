package com.bookclub.book_club.service;

import com.bookclub.book_club.model.AvailabilityStatus;
import com.bookclub.book_club.model.Book;
import com.bookclub.book_club.model.Language;
import dto.AddBookRequest;

import java.math.BigDecimal;
import java.util.List;

public interface IBookService {

    Book addBook(AddBookRequest addBookRequest);
    Book getBookById(Long id);
    void deleteBookById(Long id);
    void updateBook(Book book, Long id);
    List<Book> getAllBooks();
    List<Book> getBooksByCategory(String category);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByPublisher(String publisher);
    List<Book> getBooksByPriceRange(BigDecimal minimumPrice, BigDecimal maximumPrice);
    List<Book> getBooksByAvailabilityStatus(AvailabilityStatus status);
    List<Book> getBooksByLanguage(Language language);
    List<Book> getBooksByTitle(String title);
}
