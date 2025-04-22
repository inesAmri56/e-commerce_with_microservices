package com.example.galleryservice.service.serviceImp;

import com.example.galleryservice.dtos.request.GalleryRequest;
import com.example.galleryservice.dtos.response.GalleryResponse;
import com.example.galleryservice.model.Gallery;
import com.example.galleryservice.repository.GalleryDAO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class GalleryServiceImp implements GalleryService {
    public static GalleryDAO gallerydao;
    //private final ProductDAO productDAO;

    public GalleryServiceImp(GalleryDAO gallerydao) {
        this.gallerydao = gallerydao;
        //this.productDAO = productDAO;
    }
    @Override
    public GalleryResponse createGallery(GalleryRequest galleryRequest) {
        Gallery gallery= GalleryResponse.toEntity(galleryRequest);
        Gallery saveGallery=gallerydao.save(gallery);
        return  GalleryResponse.fromEntity(saveGallery);

    }

    @Override
    public GalleryResponse getGallery(Long id) {

        return gallerydao.findById(id).map(GalleryResponse::fromEntity).
                orElseThrow(()->new RuntimeException("gallery Not found"));
    }

    @Override
    public List<GalleryResponse> getAllGalleries() {

        return gallerydao.findAll().stream().
                map(GalleryResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public GalleryResponse udpdateGallery(GalleryRequest galleryRequest, Long id) {

        Gallery gallery =gallerydao.findById(id).orElseThrow(
                ()->new RuntimeException("gallery not found with this id:"+id));
        if(gallery !=null){
            Gallery cat = GalleryResponse.toEntity(galleryRequest);
            cat.setId(id);
            Gallery savedGallery=gallerydao.save(cat);
            return GalleryResponse.fromEntity(savedGallery);
        }else{
            return  null;
        }
    }

    @Override
    public HashMap<String, String> deleteGallery(Long id) {
        HashMap message = new HashMap<>() ;
        Gallery gallery=gallerydao.findById(id).orElseThrow(null);
        if(gallery!=null){
            try{
                gallerydao.deleteById(id);
                message.put("Gallery","Gallery deleted successfully");
            }catch(Exception e){
                message.put("Gallery",e.getMessage());
            }
        }else {
            message.put("message", "Gallery not found" + id);
        }
        return message;
    }

    @Override
    public GalleryResponse createGalleryWithProduct(GalleryRequest galleryRequest, Long id) {
        //Product product = productDAO.findById(id).orElseThrow(()->new RuntimeException("product not found with this id:"+id));
        Gallery gallery =GalleryResponse.toEntity(galleryRequest);
       // gallery.setProduct(product);
        Gallery savedGallery = gallerydao.save(gallery);
        return GalleryResponse.fromEntity(savedGallery);
    }
}
