package com.bookclub.book_club.service;

import com.bookclub.book_club.model.Author;
import dto.AddAuthorRequest;

import java.util.List;

public interface IAuthorService {

    Author addAuthor(AddAuthorRequest addAuthorRequest);
    List<Author> getAllAuthors();
}
