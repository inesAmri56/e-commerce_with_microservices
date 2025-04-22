package com.example.orderservice.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table (name = "custmer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private  String description;
    int qte_total;
    double priceTotal;
    boolean state;
//    @ManyToOne
//    @JoinColumn(name = "client_id",nullable = false)
//    @JsonIgnoreProperties("order")
//    private Client client;
//    @ManyToOne
//    @JoinColumn(name = "driver_id",nullable = false)
//    @JsonIgnoreProperties("order")
//    private Driver driver;
//    @ManyToMany
//    @JsonIgnoreProperties("order")
//    @JoinTable(name = "order_product",joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
    //private Collection<Product> products;

}
