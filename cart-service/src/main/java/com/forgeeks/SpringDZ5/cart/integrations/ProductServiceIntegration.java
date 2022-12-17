package com.forgeeks.SpringDZ5.cart.integrations;

import com.forgeeks.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
//    private final RestTemplate restTemplate;
    private final WebClient productServiceWebClient;

//    public ProductDto findById(Long id) {
////        return restTemplate.getForObject("http://localhost:8080/app-core/api/v1/products/" + id, ProductDto.class);
//
//    }

    public ProductDto findById(Long id) {
        return productServiceWebClient.get()
                .uri("/api/v1/products/" + id)
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();
    }

    public void clear(String username) {
        productServiceWebClient.get()
                .uri("/api/v1/cart/0/clear")
                .header("username", username)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
