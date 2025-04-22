package com.example.galleryservice.controller;
import com.example.galleryservice.dtos.request.GalleryRequest;
import com.example.galleryservice.dtos.response.GalleryResponse;
import com.example.galleryservice.service.serviceImp.GalleryService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/galleryapi")
public class GalleryController {
    public static GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @PostMapping("/createGallery")
    public GalleryResponse createGalleryRespose(@RequestBody GalleryRequest galleryRequest) {
        return galleryService.createGallery(galleryRequest);
    }
    @PostMapping("/createGalleryWithProduct/{id}")
    public GalleryResponse createGalleryWithProduct(@RequestBody GalleryRequest galleryRequest,@PathVariable Long id) {
        return galleryService.createGalleryWithProduct(galleryRequest,id);
    }

    @GetMapping("/getAllGalleries")
    public List<GalleryResponse> getAllGalleries() {

        return galleryService.getAllGalleries();
    }

    @GetMapping("/getGalleryById/{id}")
    public GalleryResponse getGalleryById(@PathVariable Long id) {
        return galleryService.getGallery(id);
    }

    @PutMapping("/updateGallery/{id}")
    public GalleryResponse updateGallery(@PathVariable Long id, @RequestBody GalleryRequest galleryRequest) {
        return galleryService.udpdateGallery(galleryRequest, id);
    }

    @DeleteMapping("/deletegallery/{id}")
    public HashMap<String, String> deleteClientById(@PathVariable Long id) {
        return galleryService.deleteGallery(id);
    }
}