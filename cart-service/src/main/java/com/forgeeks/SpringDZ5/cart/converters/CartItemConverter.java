package com.forgeeks.SpringDZ5.cart.converters;

import com.forgeeks.SpringDZ5.cart.utils.CartItem;
import com.forgeeks.api.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem c) {
        return new CartItemDto(c.getProductId(), c.getProductTitle(), c.getQuantity(), c.getPricePerProduct(), c.getPrice());
    }
}
