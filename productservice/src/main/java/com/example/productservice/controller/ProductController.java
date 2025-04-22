package com.example.productservice.controller;
import com.example.productservice.dtos.request.ProductRequest;
import com.example.productservice.dtos.response.ProductResponse;
import com.example.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/productapi")
public class ProductController {
    public static ProductService productService;
    public ProductController( ProductService productService) {
        this.productService=productService;
    }
    @PostMapping("/createProduct")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }
    @PostMapping("/createProductWithSubCategoryProvider/{providerId}/{subcategoryId}")
    public ProductResponse createProductWithSubCategoryProvider(@RequestBody ProductRequest productRequest,@PathVariable Long providerId,@PathVariable Long subcategoryId) {
        return productService.createProductWithSubCategoryProvider(productRequest,subcategoryId,providerId);
    }
    @GetMapping("/getAllProducts")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping ("/getProductById/{id}")
    public ProductResponse getResponseById(@PathVariable Long id) {
        return  productService.getProduct(id) ;  }
    @PutMapping("/updateProduct/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(productRequest, id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public HashMap<String, String> deleteOrderById(@PathVariable Long id) {
        return productService.dleteProduct(id);
    }
}
