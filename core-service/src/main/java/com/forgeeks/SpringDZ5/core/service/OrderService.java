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
//    private final UserService userService;
    private final CartServiceIntegration cartServiceIntegration;
    private final OrderConverter orderConverter;

    @Transactional
    public void createOrder(Principal principal) {
//        User user = userService.findByUsername(principal.getName()).get();
        //Сделать CartDto?
        CartDto cartDto = cartServiceIntegration.getCurrentCart();

        Order order = new Order();
//        order.setUser(user);
        order.setTotalPrice(cartDto.getTotalPrice());

        List<OrderItem> orderItemList = new ArrayList<>();

        for (CartItemDto cartItemDto : cartDto.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setPrice(cartItemDto.getPrice());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setPricePerProduct(cartItemDto.getPricePerProduct());
            Product product = productService.findById(cartItemDto.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден"));
            orderItem.setProduct(product);
            orderItemList.add(orderItem);
        }

        order.setItems(orderItemList);
        orderRepository.save(order);
        System.out.println("YEAH!");
//      cartServiceIntegration.clearCart();

//        List<CartItemDto> cartItemDtoList = cartServiceIntegration.getCurrentCart(1l).getItems();
//        OrderDto orderDto = new OrderDto();
////        orderDto.setUserInfoDto(user);
//        orderDto.setItems(new ArrayList<>());
//        orderDto.setTotalPrice(null);
//        orderRepository.save(orderDto);
//        return orderDto;
    }
}
