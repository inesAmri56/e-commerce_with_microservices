package com.example.subcategoryservice.repository;
import com.example.subcategoryservice.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryDAO extends JpaRepository<SubCategory,Long> {
}
