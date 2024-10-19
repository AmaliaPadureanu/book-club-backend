package com.bookclub.book_club.controller;

import com.bookclub.book_club.exceptions.EntityAlreadyExistsException;
import com.bookclub.book_club.model.Category;
import com.bookclub.book_club.service.ICategoryService;
import dto.AddCategoryRequest;
import dto.ApiResponse;
import dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryService.getAllCategories().forEach(category -> {
                    CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
                    categoryDtos.add(categoryDto);

                });
        return ResponseEntity.ok(new ApiResponse("Success!", categoryDtos));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        try {
            Category category = categoryService.addCategory(addCategoryRequest);
            CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
            return ResponseEntity.ok(new ApiResponse("Category was added!", categoryDto));
        } catch (EntityAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
