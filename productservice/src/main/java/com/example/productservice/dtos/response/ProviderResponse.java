package com.example.productservice.dtos.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.security.Provider;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {
    private Long id;
    private String company;
    //List<ProductResponse> products;


    public static ProviderResponse fromEntity(ProviderResponse provider){
        ProviderResponse providerResponse = new ProviderResponse();
        providerResponse.setId(providerResponse.getId());
        providerResponse.setCompany(providerResponse.getCompany());

        // Si tu veux inclure les produits associés :
        // if (provider.getProducts() != null) {
        //     providerResponse.setProducts(
        //         provider.getProducts().stream()
        //             .map(ProductResponse::fromEntity)
        //             .collect(Collectors.toList())
        //     );
        // }

        return providerResponse;
    }}

//    public static ProviderResponse fromEntity(ProviderResponse provider){
//        ProviderResponse providerResponse = new ProviderResponse();
//        BeanUtils.copyProperties(provider,providerResponse);
////        if(provider.getProducts()!=null){
////            providerResponse.setProducts(
////                    provider.getProducts().stream().map(
////                            ProductResponse::fromEntity).collect(Collectors.toList())
////            );
////        }
//        return providerResponse;
//    }
//
//}
