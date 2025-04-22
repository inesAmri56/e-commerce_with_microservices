package com.example.driverservice.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table (name = "driver")
@Getter @Setter @NoArgsConstructor

public class Driver {

    String adress;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    public Driver(Long id, String firstName, String lastName, String Email, String phoneNumber,
//                  String password, String username, String adress) {
//        super(id, firstName, lastName, Email, phoneNumber, password, username);
//        this.adress = adress;
//    }

    public Driver(String adress ,Long id) {
        this.adress = adress;
        this.id = id;
    }


//    @OneToMany(mappedBy = "driver")
//    @JsonIgnoreProperties("driver")
    //private Collection <Order> orders ;
}

