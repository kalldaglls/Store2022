package com.forgeeks.SpringDZ5.core.converters;


import com.forgeeks.SpringDZ5.core.entities.Order;
import com.forgeeks.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order o) {
        return new OrderDto(o.getId(), o.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()), o.getTotalPrice());
    }
}
