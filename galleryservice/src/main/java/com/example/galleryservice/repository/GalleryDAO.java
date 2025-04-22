package com.example.galleryservice.repository;



import com.example.galleryservice.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryDAO extends JpaRepository<Gallery,Long> {

}
