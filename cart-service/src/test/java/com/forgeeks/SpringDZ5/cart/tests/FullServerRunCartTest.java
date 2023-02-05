package com.forgeeks.SpringDZ5.cart.tests;

import com.forgeeks.SpringDZ5.cart.exceptions.ResourceNotFoundException;
import com.forgeeks.api.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class FullServerRunCartTest {
    @Autowired
    private TestRestTemplate restTemplate;
//    private WebClient productServiceWebClient;

    @Test
    public void fullRestTest() {
        ProductDto product = restTemplate.getForObject("app-core/api/v1/products/" + 1l, ProductDto.class);
        System.out.println(product);
//        ProductDto product = productServiceWebClient.get()
//                .uri("/api/v1/products/" + 1l)
//                .retrieve()
//                .onStatus(httpStatus -> httpStatus.value() == HttpStatus.NOT_FOUND.value(),
//                        clientResponse -> Mono.error(new ResourceNotFoundException("Товар не найден")))
//                .onStatus(httpStatus -> httpStatus.value() == HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                        clientResponse -> Mono.error(new ResourceNotFoundException("500")))
//                .bodyToMono(ProductDto.class)
//                .block();
        assertThat(product)
                .isNotNull()
                .isInstanceOf(ProductDto.class);
    }
}
