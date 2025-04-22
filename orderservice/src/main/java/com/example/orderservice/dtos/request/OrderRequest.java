package com.example.orderservice.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long id;
    private String ref;
    private  String description;
    int qte_total;
    double priceTotal;
    boolean state;
}

