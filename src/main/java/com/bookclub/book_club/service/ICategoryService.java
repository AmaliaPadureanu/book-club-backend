package com.bookclub.book_club.service;

import com.bookclub.book_club.model.Category;
import dto.AddCategoryRequest;

import java.util.List;

public interface ICategoryService {

    Category addCategory(AddCategoryRequest addCategoryRequest);
    List<Category> getAllCategories();
}
