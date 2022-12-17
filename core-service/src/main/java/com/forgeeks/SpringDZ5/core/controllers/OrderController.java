package com.forgeeks.SpringDZ5.core.controllers;

import com.forgeeks.SpringDZ5.core.integrations.CartServiceIntegration;
import com.forgeeks.SpringDZ5.core.service.OrderService;
import com.forgeeks.api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
//@CrossOrigin("*")
public class OrderController {
    private final CartServiceIntegration cartServiceIntegration;
    private final OrderService orderService;
//    private final UserService userService;

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
