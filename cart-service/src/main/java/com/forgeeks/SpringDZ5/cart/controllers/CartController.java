package com.forgeeks.SpringDZ5.cart.controllers;

import com.forgeeks.SpringDZ5.cart.converters.CartConverter;
import com.forgeeks.SpringDZ5.cart.service.CartService;
import com.forgeeks.api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
//@CrossOrigin("*")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
        System.out.println(cartService.getCurrentCart());
    }

    @GetMapping
    public CartDto getCurrentCart() {
        return cartConverter.entityToDto(cartService.getCurrentCart());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.delete(id);
    }
}
