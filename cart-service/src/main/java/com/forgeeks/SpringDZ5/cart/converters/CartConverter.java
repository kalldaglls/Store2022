package com.forgeeks.SpringDZ5.cart.converters;

import com.forgeeks.SpringDZ5.cart.utils.Cart;
import com.forgeeks.api.CartDto;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.stream.Collectors;

@Component
@Data
public class CartConverter {
    private final CartItemConverter cartItemConverter;

    public CartDto entityToDto(Cart c) {
        return new CartDto(c.getItems().stream().map(cartItemConverter::entityToDto).collect(Collectors.toList()), c.getTotalPrice());
    }
}
