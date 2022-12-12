package com.forgeeks.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Long id;
    private UserInfoDto userInfoDto;
    private BigDecimal totalPrice;
    private List<OrderItemDto> items;

    public OrderDto() {
    }

    public OrderDto(Long id, UserInfoDto userInfoDto, BigDecimal totalPrice, List<OrderItemDto> items) {
        this.id = id;
        this.userInfoDto = userInfoDto;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfoDto getUserInfoDto() {
        return userInfoDto;
    }

    public void setUserInfoDto(UserInfoDto userInfoDto) {
        this.userInfoDto = userInfoDto;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
