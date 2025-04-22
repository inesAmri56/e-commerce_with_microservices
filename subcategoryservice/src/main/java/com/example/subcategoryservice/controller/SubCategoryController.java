package com.example.subcategoryservice.controller;
import com.example.subcategoryservice.dto.request.SubCategoryRequest;
import com.example.subcategoryservice.dto.response.SubCategoryResponse;
import com.example.subcategoryservice.service.SubCategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
    @RestController
    @CrossOrigin("*")
    @RequestMapping("/subCategoryapi")
    public class SubCategoryController {
        public  static SubCategoryService subcategoryservice;
        private final SubCategoryService subCategoryService;
        public SubCategoryController(SubCategoryService subCategoryService) {
            this.subCategoryService = subCategoryService;
        }

        @PostMapping("/createSubCategory")
        public SubCategoryResponse createSubCategory(@RequestBody SubCategoryRequest subCategoryRequest) {
            return  subCategoryService.createSubCategory(subCategoryRequest);
        }
            @PostMapping("/createSubCategorywithCategory/{id}")
    public  SubCategoryResponse createSubCategorywithCategory(@RequestBody SubCategoryRequest subCategoryRequest,@PathVariable Long id){
        return subCategoryService.createSubCategorywithCtegory(subCategoryRequest,id);
    }
        @GetMapping("/getSubCategoryById/{id}")
        public SubCategoryResponse getSubCategoryById(@PathVariable Long id) {
            return subCategoryService.getSubCategory(id);
        }
        @GetMapping("/getAllSubCategories")
        public List<SubCategoryResponse> getallSubCategory(){
            return subCategoryService.getAllSubCategories();
        }
        @PutMapping("/updateSubcategory/{id}")
        public SubCategoryResponse updateClient(@PathVariable Long id, @RequestBody SubCategoryRequest subCategoryRequest) {
            return subCategoryService.updateSubCategory(subCategoryRequest, id);
        }

        @DeleteMapping("/deleteSubcategory/{id}")
        public HashMap<String, String> deleteOrderById(@PathVariable Long id) {
            return subCategoryService.deleteSubCategory(id);
        }
    }


