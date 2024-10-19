package com.bookclub.book_club.service;

import com.bookclub.book_club.exceptions.EntityAlreadyExistsException;
import com.bookclub.book_club.model.Category;
import com.bookclub.book_club.repository.CategoryRepository;
import dto.AddCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(AddCategoryRequest addCategoryRequest) {
        Optional<Category> category = categoryRepository.findByName(addCategoryRequest.getName());
        if (category.isPresent()) {
            throw new EntityAlreadyExistsException("Category already exists!");
        }

        Category newCategory = new Category(addCategoryRequest.getName());
        return categoryRepository.save(newCategory);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
