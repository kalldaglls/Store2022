package com.forgeeks.SpringDZ5.cart.utils;

import com.forgeeks.api.ProductDto;
import lombok.Data;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private BigDecimal totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void add(ProductDto p) {
        for (CartItem item : items) {
            if (item.getProductId().equals(p.getId())) {
                item.incrementQuantity();
                recalculate();
                return;
            }
        }
        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.add(cartItem);
        recalculate();
    }

//    public void add(Product product) {
//        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
//        recalculate();
//    }

    public void remove(ProductDto p) {
        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.remove(cartItem);
        recalculate();
        for (CartItem item : items) {
//            if (item.getProductId().equals(p.getId()) && item.getQuantity() <= 1) {
//                items.clear();
//                break;
//            }
            if (item.getProductId().equals(p.getId())) {
                item.decrementQuantity();
                recalculate();
                return;
            }
        }
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));
    }
}
