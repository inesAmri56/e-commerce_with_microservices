package com.example.subcategoryservice.service.serviceImp;
import com.example.subcategoryservice.dto.request.SubCategoryRequest;
import com.example.subcategoryservice.dto.response.CategoryResponse;
import com.example.subcategoryservice.dto.response.SubCategoryResponse;
import com.example.subcategoryservice.model.SubCategory;
import com.example.subcategoryservice.openfeignsubcategorycategory.CategoryRestClient;
import com.example.subcategoryservice.repository.SubCategoryDAO;
import com.example.subcategoryservice.service.SubCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
@Service
public class SubCategoryServiceImp implements SubCategoryService {
    public static SubCategoryDAO subcategorydao;
    public static CategoryRestClient categoryrestclient;
    public SubCategoryServiceImp(SubCategoryDAO subcategorydao,CategoryRestClient categoryrestclient) {

        this.subcategorydao = subcategorydao;
        this.categoryrestclient = categoryrestclient;
    }

    @Override
    public SubCategoryResponse createSubCategorywithCtegory(SubCategoryRequest subCategoryRequest, Long id) {
        CategoryResponse categoryResponse = categoryrestclient.getCategory(id);
        if (categoryResponse == null) {
            throw new RuntimeException("Category not found with ID: " + id);
        }
        SubCategory subCategory = SubCategoryResponse.toEntity(subCategoryRequest);
        subCategory.setCategoryId(categoryResponse.getId());
        SubCategory savedSubCategory = subcategorydao.save(subCategory);
        return SubCategoryResponse.fromEntity(savedSubCategory,categoryrestclient);
    }

    @Override
    public SubCategoryResponse createSubCategory(SubCategoryRequest subCategoryRequest) {
            SubCategory subCategory = SubCategoryResponse.toEntity(subCategoryRequest);
            SubCategory savedSubcategory = subcategorydao.save(subCategory);
            return SubCategoryResponse.fromEntity(savedSubcategory,categoryrestclient);
        }


    @Override
    public SubCategoryResponse getSubCategory(Long id) {
        return subcategorydao.findById(id)
                .map(subcategory -> {
                    // Créer la réponse à partir de l'entité
                    SubCategoryResponse response = SubCategoryResponse.fromEntity(subcategory, categoryrestclient);

                    // Récupérer et inclure les détails de category
                    if ( subcategory.getCategoryResponse()!= null) {
                        response.setCategoryResponse(
                                CategoryResponse.fromEntity(subcategory.getCategoryResponse())
                        );
                    }

                    return response;
                })
                .orElseThrow(() ->new RuntimeException("subcategory not found with this id:" +id));
    }

    @Override
    public List<SubCategoryResponse> getAllSubCategories() {
        return subcategorydao.findAll().stream()
                .map(subCategories -> {
            SubCategoryResponse response = SubCategoryResponse.fromEntity(subCategories, categoryrestclient);
            if (subCategories.getCategoryResponse() != null) {
                response.setCategoryResponse(
                       CategoryResponse.fromEntity(subCategories.getCategoryResponse())
                );
            }

            return response;
        })
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryResponse updateSubCategory(SubCategoryRequest subCategoryRequest, Long id) {
        SubCategory subcategory=subcategorydao.findById(id).orElseThrow(()->
                new RuntimeException("subcategory not found with this id:" +id));
        if (subcategory != null) {
            SubCategory sub = SubCategoryResponse.toEntity(subCategoryRequest);
            sub.setCategoryId(id);
            sub.setDescription(sub.getDescription() == null ? subcategory.getDescription() : sub.getDescription());
            SubCategory savedcandidat = subcategorydao.save(sub);
            return SubCategoryResponse.fromEntity(savedcandidat, categoryrestclient);
        }else{
            return null;
        }
    }

    @Override
    public HashMap<String, String> deleteSubCategory(Long id) {
        HashMap message = new HashMap<>() ;
        SubCategory subcategory=subcategorydao.findById(id).orElseThrow(null);
        if(subcategory!=null){
            try{
                subcategorydao.deleteById(id);
                message.put("subcategory","subcategory deleted successfully");
            }catch(Exception e){
                message.put("provider",e.getMessage());
            }
        }else {
            message.put("message", "provider not found" + id);
        }
        return message;
    }


}
