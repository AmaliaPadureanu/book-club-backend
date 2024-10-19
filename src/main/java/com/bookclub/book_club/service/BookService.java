package com.bookclub.book_club.service;

import com.bookclub.book_club.exceptions.AuthorNotFoundException;
import com.bookclub.book_club.exceptions.BookNotFoundException;
import com.bookclub.book_club.exceptions.CategoryNotFoundException;
import com.bookclub.book_club.model.*;
import com.bookclub.book_club.repository.AuthorRepository;
import com.bookclub.book_club.repository.BookRepository;
import com.bookclub.book_club.repository.CategoryRepository;
import dto.AddBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Book addBook(AddBookRequest addBookRequest) {
        Category category = categoryRepository.findByName(addBookRequest.getCategory().getName())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found!"));

        List<Author> authors = new ArrayList<>();
        for (Author author : addBookRequest.getAuthors()) {
            authorRepository.findByName(author.getFirstName(), author.getLastName())
                    .ifPresentOrElse(authors::add, () -> {throw new AuthorNotFoundException("Author not found!");
            });
        }

        Book book = new Book(
                category,
                authors,
                addBookRequest.getTitle(),
                addBookRequest.getNumberOfPages(),
                addBookRequest.getDescription(),
                addBookRequest.getPublisher(),
                addBookRequest.getPrice(),
                addBookRequest.getAvailabilityStatus(),
                addBookRequest.getInventory(),
                addBookRequest.getLanguage(),
                addBookRequest.getPublicationDate()
        );
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found!"));
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.findById(id).ifPresentOrElse(bookRepository::delete, () -> {
            throw new BookNotFoundException("Book not found!");
        });
    }

    @Override
    public void updateBook(Book book, Long id) {

    }

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return List.of();
    }

    @Override
    public List<Book> getBooksByPublisher(String publisher) {
        return List.of();
    }

    @Override
    public List<Book> getBooksByPriceRange(BigDecimal minimumPrice, BigDecimal maximumPrice) {
        return List.of();
    }

    @Override
    public List<Book> getBooksByAvailabilityStatus(AvailabilityStatus status) {
        return List.of();
    }

    @Override
    public List<Book> getBooksByLanguage(Language language) {
        return List.of();
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
