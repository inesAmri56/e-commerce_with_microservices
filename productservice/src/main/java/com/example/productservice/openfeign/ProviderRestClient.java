package com.example.productservice.openfeign;

import com.example.productservice.dtos.response.ProviderResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "PROVIDERSERVICE")
public interface ProviderRestClient {
    @GetMapping("/providerapi/getProviderById/{id}")
    public ProviderResponse getProviderById(@PathVariable Long id);
}
