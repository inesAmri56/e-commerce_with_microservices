package org.example.categoryservice.repositories;

import org.example.categoryservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Long> {

}