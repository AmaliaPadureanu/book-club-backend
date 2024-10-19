package com.bookclub.book_club.controller;

import com.bookclub.book_club.exceptions.EntityAlreadyExistsException;
import com.bookclub.book_club.model.Author;
import com.bookclub.book_club.model.Category;
import com.bookclub.book_club.service.IAuthorService;
import dto.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/authors")
public class AuthorController {

    private final IAuthorService authorService;
    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllAuthors() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        authorService.getAllAuthors().forEach(author -> {
            AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
            authorDtos.add(authorDto);

        });
        return ResponseEntity.ok(new ApiResponse("Success!", authorDtos));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addAuthor(@RequestBody AddAuthorRequest addAuthorRequest) {
        try {
            Author author = authorService.addAuthor(addAuthorRequest);
            AuthorDtoSimplified authorDtoSimplified = modelMapper.map(author, AuthorDtoSimplified.class);
            return ResponseEntity.ok(new ApiResponse("Author was added!", authorDtoSimplified));
        } catch (EntityAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
