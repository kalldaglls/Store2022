package com.forgeeks.SpringDZ5.core.converters;

import com.forgeeks.SpringDZ5.core.entities.OrderItem;
import com.forgeeks.api.OrderItemDto;
import org.springframework.stereotype.Component;


@Component
public class OrderItemConverter {
    public OrderItemDto entityToDto(OrderItem o) {
        return new OrderItemDto(o.getProduct().getId(), o.getProduct().getTitle(), o.getQuantity(), o.getPricePerProduct(), o.getPrice());
    }
}
