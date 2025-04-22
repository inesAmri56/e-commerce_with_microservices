package com.example.subcategoryservice.dto.response;
import com.example.subcategoryservice.dto.request.SubCategoryRequest;
import com.example.subcategoryservice.model.SubCategory;
import com.example.subcategoryservice.openfeignsubcategorycategory.CategoryRestClient;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponse {
    private Long id;
    private String description;
    private String name;
    private CategoryResponse categoryResponse;
    // List<ProductResponse> pproducts;

    public static SubCategoryResponse fromEntity(SubCategory subcategory, CategoryRestClient categoryRestClient) {
        SubCategoryResponse subcategoryResonse = new SubCategoryResponse();
        BeanUtils.copyProperties(subcategory, subcategoryResonse);
        // if(subcategory.getProducts()!=null) {
//            subcategoryResonse.setPproducts(subcategory.getProducts().stream().
//                    map(ProductResponse::fromEntity).collect(Collectors.toList()));
        // }
        if (subcategory.getCategoryId()!=null) {
            subcategoryResonse.setCategoryResponse(categoryRestClient.getCategory(subcategory.getCategoryId()));
        }
        return subcategoryResonse;
    }

    public static SubCategory toEntity(SubCategoryRequest subCategoryRequest){
        SubCategory subCategory = new SubCategory();
        BeanUtils.copyProperties(subCategoryRequest,subCategory);
        return subCategory;
    }
}
