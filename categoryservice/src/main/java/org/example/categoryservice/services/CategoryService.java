package org.example.categoryservice.services;



import org.example.categoryservice.dtos.request.CategoryRequest;
import org.example.categoryservice.dtos.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(Long id);
    CategoryResponse updateCategory(CategoryRequest categoryRequest, Long id);
    HashMap<String,String> deleteCategory(Long id);



}

