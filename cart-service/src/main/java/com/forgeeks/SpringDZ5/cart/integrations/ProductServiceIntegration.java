package com.forgeeks.SpringDZ5.cart.integrations;

import com.forgeeks.SpringDZ5.cart.exceptions.ResourceNotFoundException;
import com.forgeeks.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final RestTemplate restTemplate;
    private final WebClient productServiceWebClient;

//    public ProductDto findById(Long id) {
//        return restTemplate.getForObject("http://localhost:8080/app-core/api/v1/products/" + id, ProductDto.class);
//
//    }

    public ProductDto findById(Long id) {
        return productServiceWebClient.get()
                .uri("/api/v1/products/" + id)
                .retrieve()
                .onStatus(httpStatus -> httpStatus.value() == HttpStatus.NOT_FOUND.value(),
                        clientResponse -> Mono.error(new ResourceNotFoundException("Товар не найден")))
                .onStatus(httpStatus -> httpStatus.value() == HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        clientResponse -> Mono.error(new ResourceNotFoundException("500")))
                .bodyToMono(ProductDto.class)
                .block();
    }

//    public void clear(String username) {
//        productServiceWebClient.get()
//                .uri("/api/v1/cart/clear")
//                .header("username", username)
//                .retrieve()
//                .toBodilessEntity()
//                .block();
//    }
}
