package com.example.productservice.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long id;
    double price;
    String ref;
    String description;
    int qte;
    private  Long providerId;
    private Long subcategoryId;
}
