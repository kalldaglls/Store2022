package com.forgeeks.SpringDZ5.cart.service;

import com.forgeeks.SpringDZ5.cart.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.cart.integrations.ProductServiceIntegration;
import com.forgeeks.SpringDZ5.cart.utils.Cart;
import com.forgeeks.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CartService {
//    private final ProductService productService;
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;
//    private final RedisTemplate<Long, Cart> redisTemplate;
    private Map<String, Cart> carts;

    @PostConstruct
    public void init() {
//        tempCart = new Cart();
        carts = new HashMap<>();
    }

    public Cart getCurrentCart(String cartId) {
//        if (!redisTemplate.hasKey(tempCart.))
//        redisTemplate.opsForValue().set("1", tempCart);
//        return tempCart;
//        if (redisTemplate.opsForValue().get(1L) != null) {
//            redisTemplate.opsForValue().set(1L, tempCart);
//        }
//        return (Cart)redisTemplate.opsForValue().get(1L);
        if (!carts.containsKey(cartId)) {
            Cart cart = new Cart();
            carts.put(cartId, cart);
        }
        return carts.get(cartId);
    }

    public void add(String cartId, Long productId) {
//        execute(cart -> {
//            ProductDto p = productServiceIntegration.findById(productId);
//            cart.add(p);
//        });
//        Cart cart = getCurrentCart();
        ProductDto product = productServiceIntegration.findById(productId);
////        redisTemplate.opsForValue().set(1l, tempCart);
        getCurrentCart(cartId).add(product);
//        tempCart.add(product);
    }

    public void delete(String cartId, Long id) {
        ProductDto product = productServiceIntegration.findById(id);
        getCurrentCart(cartId).remove(product);
    }

    public void clearCart(String cartId) {
        getCurrentCart(cartId).clear();
    }


//    private void execute(Consumer<Cart> action) {
//        Cart cart = getCurrentCart();
//        action.accept(cart);
//        redisTemplate.opsForValue().set(1L, cart);
//    }

}
