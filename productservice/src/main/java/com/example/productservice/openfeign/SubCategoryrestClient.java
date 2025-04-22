package com.example.productservice.openfeign;

import com.example.productservice.dtos.response.SubCategoryResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "SUBCATEGORYSERVICE")
public interface SubCategoryrestClient {
    @GetMapping("/subCategoryapi/getSubCategoryById/{id}")
    public SubCategoryResponse getSubCategoryById(@PathVariable Long id);
}

