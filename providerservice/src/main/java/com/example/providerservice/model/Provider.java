package com.example.providerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "provider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provider    {
    private String company;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Provider(Long id, String firstName, String lastName, String Email, String phoneNumber,
                    String password, String username, Long id1, String company) {
        this.id = id1;
        this.company = company;
    }
//    @OneToMany(mappedBy = "provider")
//    @JsonIgnoreProperties("provider")
//    private Collection <Product> products;

}
