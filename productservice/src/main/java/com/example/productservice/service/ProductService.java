package com.example.productservice.service;
import com.example.productservice.dtos.request.ProductRequest;
import com.example.productservice.dtos.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface ProductService {
   ProductResponse createProduct(ProductRequest productRequest);
   ProductResponse getProduct(Long id);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(ProductRequest productreuest, Long id);
   HashMap<String,String> dleteProduct(Long id);
    ProductResponse createProductWithSubCategoryProvider(ProductRequest productrequest, Long ProviderId,Long SubCategoryId);

}
