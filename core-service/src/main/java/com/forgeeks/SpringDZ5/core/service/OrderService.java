package com.forgeeks.SpringDZ5.core.service;

import com.forgeeks.SpringDZ5.core.converters.OrderConverter;
import com.forgeeks.SpringDZ5.core.entities.Order;
import com.forgeeks.SpringDZ5.core.entities.OrderItem;
import com.forgeeks.SpringDZ5.core.entities.Product;
import com.forgeeks.SpringDZ5.core.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.core.integrations.CartServiceIntegration;
import com.forgeeks.SpringDZ5.core.repositories.OrderRepository;
import com.forgeeks.api.CartDto;
import com.forgeeks.api.CartItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final CartServiceIntegration cartServiceIntegration;

    @Transactional
    public void createOrder(String username) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart(username);
        if (cartDto.getItems().isEmpty()) {
            throw new IllegalStateException("Нельзя оформить заказ для пустой корзины");
        }

        Order order = new Order();
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setUsername(username);
        order.setItems(new ArrayList<>());

        cartDto.getItems().forEach(ci -> {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setPrice(ci.getPrice());
            oi.setQuantity(ci.getQuantity());
            oi.setPricePerProduct(ci.getPricePerProduct());
            oi.setProduct(productService.findById(ci.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
            order.getItems().add(oi);
        });
        orderRepository.save(order);

        cartServiceIntegration.clearCart(username);
        this.findUserOrders(username);
    }

    public List<Order> findUserOrders(String username){
        return orderRepository.findAllByUsername(username);
    }
}
