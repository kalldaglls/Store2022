package com.forgeeks.SpringDZ5.core.controllers;

import com.forgeeks.SpringDZ5.core.entities.Order;
import com.forgeeks.SpringDZ5.core.entities.User;
import com.forgeeks.SpringDZ5.core.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.core.integrations.CartServiceIntegration;
import com.forgeeks.SpringDZ5.core.service.OrderService;
import com.forgeeks.SpringDZ5.core.service.UserService;
import com.forgeeks.api.CartDto;
import com.forgeeks.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CartServiceIntegration cartServiceIntegration;
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(Principal principal) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart();
//        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
//        Order order = orderService.
        orderService.createOrder(principal);
        System.out.println("COOL!");
    }
}
