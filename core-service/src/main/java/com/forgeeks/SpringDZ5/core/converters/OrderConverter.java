package com.forgeeks.SpringDZ5.core.converters;

import com.forgeeks.SpringDZ5.core.entities.OrderItem;
import com.forgeeks.api.CartItemDto;
import com.forgeeks.api.OrderItemDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderConverter {
    public List<OrderItemDto> cartItemToDto(List<CartItemDto> cartItemDtoList) {
        List<OrderItemDto> orderItemList = new ArrayList<>();
        return orderItemList;
    }
}
