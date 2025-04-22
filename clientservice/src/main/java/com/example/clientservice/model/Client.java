package com.example.clientservice.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "cilents")
@Getter @Setter  @NoArgsConstructor
public class Client {

    private  String localization;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id;

    public Client(String localization, Long id) {
        this.localization = localization;
        this.id = id;
    }
//    public Client(Long id, String firstName, String lastName, String Email, String phoneNumber,
//                  String password, String username, String localization) {
//        super(id, firstName, lastName, Email, phoneNumber, password, username);
//        this.localization = localization;
//    }
//    @OneToMany(mappedBy = "client")
//    @JsonIgnoreProperties("client")
    //private Collection<Order> orders;
}
