package com.example.subcategoryservice.model;
import com.example.subcategoryservice.dto.response.CategoryResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "subcategory")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SubCategory  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;
    private Long categoryId;
    @Transient
    CategoryResponse categoryResponse;




}


