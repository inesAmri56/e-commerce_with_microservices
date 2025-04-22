package org.example.categoryservice.controller;



import org.example.categoryservice.dtos.request.CategoryRequest;
import org.example.categoryservice.dtos.response.CategoryResponse;
import org.example.categoryservice.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/apiCategory")
public class CategoryController {
    // Injection de dépendance
    private static CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/createCategory")
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }
    @GetMapping("/getCategories")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping ("/getCategory/{id}")
    public CategoryResponse getCategory(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    @PutMapping("/updateCategory/{id}")
    public CategoryResponse updateCateGory(@RequestBody CategoryRequest categoryRequest, @PathVariable  Long id){
        return categoryService.updateCategory(categoryRequest,id);

    }
    @DeleteMapping ("/deleteCategory/{id}")
    public HashMap<String, String> deleteCategory(@PathVariable Long id ){
        return categoryService.deleteCategory(id);  }

}

