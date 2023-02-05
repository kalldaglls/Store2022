package com.forgeeks.SpringDZ5.core.integrations;

import com.forgeeks.api.CartDto;
import com.forgeeks.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;
    private final WebClient cartServiceWebClient;
    
    public CartDto getCurrentCart() {
        return restTemplate.getForObject("http://localhost:8088/app-cart/api/v1/cart/", CartDto.class);
    }

//    public CartDto getCurrentCart() {
//        return cartServiceWebClient.get()
//                .uri("/api/v1/cart/")
//                .retrieve()
//                .bodyToMono(CartDto.class)
//                .block();
//    }

//    public void clearCart() {
//    }
}
