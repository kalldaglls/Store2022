package com.forgeeks.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemDto {
    private Long id;
    private ProductDto productDto;
    private BigDecimal pricePerProduct;
    private BigDecimal price;
    private int quantity;

    public OrderItemDto() {
    }

    public OrderItemDto(Long id, ProductDto productDto, BigDecimal pricePerProduct, BigDecimal price, int quantity) {
        this.id = id;
        this.productDto = productDto;
        this.pricePerProduct = pricePerProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public BigDecimal getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(BigDecimal pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

