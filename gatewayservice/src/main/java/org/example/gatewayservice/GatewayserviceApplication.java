package org.example.gatewayservice;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserviceApplication.class, args);
    }
    RouteLocator routeLocator (RouteLocatorBuilder builder){
        return builder.routes()
                .route("category_route", r -> r.path("/categorys/").uri("lb://CATEGORIESERVICE"))
                .route("subcategory_route", r -> r.path("/subCategoryapi/").uri("lb://SUBCATEGORYESERVICE"))
                .route("client_route", r -> r.path("/clientapi/").uri("lb://CLIENTSERVICE"))
                .route("driver_route", r -> r.path("/driverapi/").uri("lb://DRIVERSERVICE"))
                .route("provider_route", r -> r.path("/providerapi/").uri("lb://PROVIDERSERVICE"))
                .route("product_route", r -> r.path("/productapi/").uri("lb://PRODUCTSERVICE"))
                .route("gallery_route", r -> r.path("/galleryapi/").uri("lb://GALLERYSERVICE"))
                .route("order_route", r -> r.path("/orderapi/").uri("lb://ORDERSERVICE"))
                .route("product_route", r -> r.path("/productapi/").uri("lb://PRODUCTSERVICE"))
                .build();
    }
    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
