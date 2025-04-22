package com.example.galleryservice.dtos.response;
import com.example.galleryservice.dtos.request.GalleryRequest;
import com.example.galleryservice.model.Gallery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GalleryResponse {
    private  Long id;
    String url_photo;
   // private Product product;
    public static GalleryResponse fromEntity(Gallery gallery){
        GalleryResponse galleryResponse = new GalleryResponse();
        BeanUtils.copyProperties(gallery,galleryResponse);
        return galleryResponse;
    }
    public static  Gallery toEntity(GalleryRequest gallleryRequest){
        Gallery gallery = new Gallery();
        BeanUtils.copyProperties(gallleryRequest,gallery);
        return gallery;

    }
}
