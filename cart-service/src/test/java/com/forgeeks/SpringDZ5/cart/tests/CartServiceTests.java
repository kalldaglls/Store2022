package com.forgeeks.SpringDZ5.cart.tests;

import com.forgeeks.SpringDZ5.cart.integrations.ProductServiceIntegration;
import com.forgeeks.SpringDZ5.cart.service.CartService;
import com.forgeeks.SpringDZ5.cart.utils.Cart;
import com.forgeeks.api.ProductDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@SpringBootTest
public class CartServiceTests {
    @Autowired
    private CartService cartService;

    @MockBean
    private ProductServiceIntegration productServiceIntegration;

    @MockBean
    private Cart tempCart;

    @Test
    public void addTest() {
        ProductDto productDto = new ProductDto(1l, "Апельсины", BigDecimal.valueOf(100.0), "Food");
        Mockito.doReturn(productDto)
                .when(productServiceIntegration)
                .findById(1l);

        cartService.add(productDto.getId());
        cartService.add(productDto.getId());
        Mockito.verify(productServiceIntegration, Mockito.times(2)).findById(ArgumentMatchers.any());
    }
}
