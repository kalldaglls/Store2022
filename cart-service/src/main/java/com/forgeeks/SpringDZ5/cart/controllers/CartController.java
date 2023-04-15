package com.forgeeks.SpringDZ5.cart.controllers;

import com.forgeeks.SpringDZ5.cart.converters.CartConverter;
import com.forgeeks.SpringDZ5.cart.service.CartService;
import com.forgeeks.api.CartDto;
import com.forgeeks.api.StringResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
//Закончил 2:00
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
//@CrossOrigin("*")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/generate_id")
    public StringResponse generateGuestCartId() {
        return new StringResponse(UUID.randomUUID().toString());
    }

    @GetMapping("/{guestCartId}/add/{productId}")
    public void addToCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId, @PathVariable Long productId) {
        String currentCartId = selectCartId(username, guestCartId);
        cartService.add(currentCartId, productId);
//        System.out.println(cartService.getCurrentCart());
    }

    @GetMapping("/{guestCartId}")
    public CartDto getCurrentCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId) {
        String currentCartId = selectCartId(username, guestCartId);
        return cartConverter.entityToDto(cartService.getCurrentCart(currentCartId));
    }

    @GetMapping("/{guestCartId}/clear")
    public void clearCurrentCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId) {
        String currentCartId = selectCartId(username, guestCartId);
        cartService.clearCart(currentCartId);
    }

    @DeleteMapping("/{guestCartId}/delete/{id}")
    public void deleteFromCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId, @PathVariable Long productId) {
        String currentCartId = selectCartId(username, guestCartId);
        cartService.delete(currentCartId, productId);
    }

    private String selectCartId(String username, String guestCartId) {
        if (username != null) {
            return username;
        }
        return guestCartId;
    }
}
