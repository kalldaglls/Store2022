package com.forgeeks.SpringDZ5.cart.tests;

import com.forgeeks.SpringDZ5.cart.integrations.ProductServiceIntegration;
import com.forgeeks.api.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceIntegrationTest {
//    @Autowired
//    private ProductServiceIntegration productServiceIntegration;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void findByIdTest() {
        ProductDto productDto = new ProductDto(1l, "Апельсины", BigDecimal.valueOf(100.0), "Food");
        ProductDto newProductDto = restTemplate.getForObject("http://localhost:8080/app-core/api/v1/products/" + productDto.getId(), ProductDto.class);
        assertThat(newProductDto)
                .isNotNull()
                .isInstanceOf(ProductDto.class);
    }
}
