package com.example.galleryservice.service.serviceImp;
import com.example.galleryservice.dtos.request.GalleryRequest;
import com.example.galleryservice.dtos.response.GalleryResponse;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
@Service
public interface GalleryService {
    GalleryResponse createGallery(GalleryRequest galleryRequest);
    GalleryResponse getGallery(Long id);
    List<GalleryResponse> getAllGalleries();
    GalleryResponse udpdateGallery(GalleryRequest galleryRequest,Long id);
    HashMap<String,String> deleteGallery(Long id);
    GalleryResponse createGalleryWithProduct(GalleryRequest galleryRequest , Long id);




}