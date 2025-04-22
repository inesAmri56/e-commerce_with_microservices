package com.example.productservice.dtos.response;
import com.example.productservice.dtos.request.ProductRequest;
import com.example.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.productservice.openfeign.ProviderRestClient;
import com.example.productservice.openfeign.SubCategoryrestClient;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    double price;
    String ref;
    String description;
    int qte;
    private SubCategoryResponse subCategory;
   private ProviderResponse privider;
    //List <GalleryResponse>galleries;
    //List<OrderResponse> orders;
    public static ProductResponse fromEntity(Product product, SubCategoryrestClient subCategoryrestClient, ProviderRestClient providerRestClient) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
//        if(product.getOrders()!=null){
//            productResponse.setOrders(
//                    product.getOrders().stream().map(OrderResponse::fromEntity)
//                            .collect(Collectors.toList()) );
//        }
//        if(product.getGalleries()!=null){
//            productResponse.setGalleries(
//                    product.getGalleries().stream().map(GalleryResponse::fromEntity).
//                            collect(Collectors.toList())
//            );

//        }
        if (product.getSubcategoryId()!=null) {
            productResponse.setSubCategory(subCategoryrestClient.getSubCategoryById(product.getSubcategoryId()));
        }
        if (product.getProviderId()!=null) {
            productResponse.setPrivider(providerRestClient.getProviderById(product.getProviderId()));
        }

        return productResponse;
    }
    public static Product toEntity(ProductRequest productRequest){
        Product product = new Product();
        BeanUtils.copyProperties(productRequest,product);
        return product;
    }
}
