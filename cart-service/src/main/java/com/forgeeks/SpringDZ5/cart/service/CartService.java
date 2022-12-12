package com.forgeeks.SpringDZ5.cart.service;

import com.forgeeks.SpringDZ5.cart.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.cart.integrations.ProductServiceIntegration;
import com.forgeeks.SpringDZ5.cart.utils.Cart;
import com.forgeeks.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
//    private final ProductService productService;
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        ProductDto product = productServiceIntegration.findById(productId);
        tempCart.add(product);
    }

    public void delete(Long id) {
        ProductDto product = productServiceIntegration.findById(id);
        tempCart.remove(product);
    }


}
