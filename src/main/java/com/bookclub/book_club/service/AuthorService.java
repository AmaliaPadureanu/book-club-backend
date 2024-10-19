package com.bookclub.book_club.service;

import com.bookclub.book_club.exceptions.EntityAlreadyExistsException;
import com.bookclub.book_club.model.Author;
import com.bookclub.book_club.repository.AuthorRepository;
import dto.AddAuthorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author addAuthor(AddAuthorRequest addAuthorRequest) {
        Optional<Author> author = authorRepository.findByName(addAuthorRequest.getFirstName(), addAuthorRequest.getLastName());
        if (author.isPresent()) {
            throw new EntityAlreadyExistsException("Author already exists!");
        }

        Author newAuthor = new Author(addAuthorRequest.getFirstName(), addAuthorRequest.getLastName());
        return authorRepository.save(newAuthor);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
