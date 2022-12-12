package com.forgeeks.SpringDZ5.core.integrations;

import com.forgeeks.api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;
    
    public CartDto getCurrentCart() {
        return restTemplate.getForObject("http://localhost:8088/app-cart/api/v1/cart/", CartDto.class);
    }

//    public void clearCart() {
//    }
}
