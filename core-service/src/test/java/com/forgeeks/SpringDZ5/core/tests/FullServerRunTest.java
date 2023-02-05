package com.forgeeks.SpringDZ5.core.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forgeeks.SpringDZ5.core.entities.Product;
import com.forgeeks.api.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class FullServerRunTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void fullRestTest() throws JsonProcessingException {
//        ParameterizedTypeReference<List<ProductDto>> typeRef = new ParameterizedTypeReference<List<ProductDto>>() {
//        };
        ObjectMapper mapper = new  ObjectMapper();
        List<ProductDto> list = mapper.convertValue(restTemplate. getForObject("/api/v1/products", List.class), new TypeReference<List<ProductDto>>() {});
        //List<ProductDto> products = restTemplate. getForObject("/api/v1/products", typeRef.getClass());
//        Iterator<ProductDto> iterator = lisiterator();

//        System.out.println(iterator.next());
        System.out.println(list.getClass());
        ProductDto productDto = new ProductDto(1l, "Молоко", BigDecimal.valueOf(100.20), "Еда");


//        assertThat(products)
//                .isNotNull()
//                .isNotEmpty()
//                .hasSize(4);
//        assertThatExceptionOfType(ClassCastException.class)
//                .isThrownBy(() -> list.get(0).getId())
//                .withMessageMatching(".*java.util.LinkedHashMap cannot be cast to .*com.forgeeks.api.ProductDto.*");
        Assertions.assertEquals(list.get(0).getId(), productDto.getId());
    }
}
