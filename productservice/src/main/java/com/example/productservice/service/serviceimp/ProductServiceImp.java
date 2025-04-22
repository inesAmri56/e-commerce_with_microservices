package com.example.productservice.service.serviceimp;
import com.example.productservice.dtos.request.ProductRequest;
import com.example.productservice.dtos.response.ProductResponse;
import com.example.productservice.dtos.response.ProviderResponse;
import com.example.productservice.dtos.response.SubCategoryResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductDAO;
import com.example.productservice.service.ProductService;
import com.example.productservice.openfeign.ProviderRestClient;
import com.example.productservice.openfeign.SubCategoryrestClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    private static ProductDAO productdao;
    private final SubCategoryrestClient subcategoryrestclient;
    private final ProviderRestClient providerRestClient;


    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = ProductResponse.toEntity(productRequest);
        SubCategoryResponse subCategory = subcategoryrestclient.getSubCategoryById(product.getSubcategoryId());
        ProviderResponse provider = providerRestClient.getProviderById(product.getProviderId());
        Product savedProduct = productdao.save(product);
        return ProductResponse.fromEntity(savedProduct, subcategoryrestclient, providerRestClient);
    }

    public ProductServiceImp(
            ProductDAO productdao,
            SubCategoryrestClient subcategoryrestclient,
            ProviderRestClient providerRestClient
    ) {
        this.productdao = productdao;
        this.subcategoryrestclient = subcategoryrestclient;
        this.providerRestClient = providerRestClient;
    }

    @Override
    public ProductResponse createProductWithSubCategoryProvider(ProductRequest productRequest, Long providerId, Long subCategoryId) {
        SubCategoryResponse subCategory = subcategoryrestclient.getSubCategoryById(subCategoryId);
        ProviderResponse provider = providerRestClient.getProviderById(providerId);

        if (subCategory == null) {
            throw new RuntimeException("SubCategory not found with ID: " + subCategoryId);
        }
        if (provider == null) {
            throw new RuntimeException("Provider not found with ID: " + providerId);
        }

        Product product = ProductResponse.toEntity(productRequest);
        product.setProviderId(providerId);
        product.setSubcategoryId(subCategoryId);

        Product savedProduct = productdao.save(product);
        return ProductResponse.fromEntity(savedProduct, subcategoryrestclient, providerRestClient);
    }


    @Override
    public List<ProductResponse> getAllProducts() {
        return productdao.findAll().stream()
                .map(products -> {
                    ProductResponse response = ProductResponse.fromEntity(products, subcategoryrestclient, providerRestClient);
                    if (products.getProviderResponse() != null) {
                        response.setPrivider(ProviderResponse.fromEntity(products.getProviderResponse()));
                    }
                    if (products.getSubCategoryResponse() != null) {
                        response.setSubCategory(SubCategoryResponse.fromEntity(products.getSubCategoryResponse()));
                    }
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProduct(Long id) {
        return productdao.findById(id).map(products -> {
                            ProductResponse response = ProductResponse.fromEntity(products, subcategoryrestclient, providerRestClient);
                            if (products.getSubCategoryResponse() != null) {
                                response.setSubCategory(SubCategoryResponse.fromEntity(products.getSubCategoryResponse()));
                            }
                            if (products.getProviderResponse() != null) {
                                response.setPrivider(ProviderResponse.fromEntity(products.getProviderResponse()));
                            }

                            return response;
                        }


                ).


                orElseThrow(() -> new RuntimeException("product not found"));
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Long id) {
        Product existingProduct = productdao.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        SubCategoryResponse subCategory = subcategoryrestclient.getSubCategoryById(productRequest.getSubcategoryId());
        ProviderResponse provider = providerRestClient.getProviderById(productRequest.getProviderId());

        existingProduct.setRef(productRequest.getRef());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setSubcategoryId(productRequest.getSubcategoryId());
        existingProduct.setProviderId(productRequest.getProviderId());

        Product savedProduct = productdao.save(existingProduct);

        // Convertit en réponse
        return ProductResponse.fromEntity(savedProduct, subcategoryrestclient, providerRestClient);
    }

    @Override
    public HashMap<String, String> dleteProduct(Long id) {

        HashMap message = new HashMap<>() ;
        Product product=productdao.findById(id).orElseThrow(null);
        if(product!=null){
            try{
                productdao.deleteById(id);
                message.put("Provider","provider deleted successfully");
            }catch(Exception e){
                message.put("provider",e.getMessage());
            }
        }else {
            message.put("message", "provider not found" + id);
        }
        return message;
    }

}
