package com.example.subcategoryservice.openfeignsubcategorycategory;

import com.example.subcategoryservice.dto.response.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "CATEGORYSERVICE")
public interface CategoryRestClient {
    @GetMapping("/apiCategory/getCategory/{id}")
    CategoryResponse getCategory(@PathVariable Long id);

}
