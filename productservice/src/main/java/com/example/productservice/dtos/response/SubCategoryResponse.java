package com.example.productservice.dtos.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponse {
    private Long id;
    private String description;
    private String name;
    List<ProductResponse> pproducts;

    public static SubCategoryResponse fromEntity(SubCategoryResponse subcategoryResponse) {
        SubCategoryResponse subcategory = new SubCategoryResponse();
        BeanUtils.copyProperties(  subcategoryResponse,subcategory );

        return subcategory;
    }


}

