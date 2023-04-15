package com.forgeeks.SpringDZ5.cart.configs;

import com.forgeeks.SpringDZ5.cart.properties.ProductServiceIntegrationProperties;

public class MainProperties {
    public static void main(String[] args) {
        ProductServiceIntegrationProperties productServiceIntegrationProperties = new ProductServiceIntegrationProperties();
        System.out.println(productServiceIntegrationProperties.getUrl());
    }
}
