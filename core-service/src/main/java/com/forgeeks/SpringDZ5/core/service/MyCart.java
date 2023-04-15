package com.forgeeks.SpringDZ5.core.service;

import com.forgeeks.SpringDZ5.core.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MyCart {
    private final List<Product> productList = new ArrayList<>();
    public void deleteById(Long id) {
       Iterator<Product> iterator = productList.iterator();

       while (iterator.hasNext()){
           Product object = iterator.next();
           if (object.getId() == id){
               iterator.remove();
           }
       }
//        for (Product p: productList) {
//            if (p.getProductId() == id){
//                productList.remove(p);
//            }
//        }
    }

    public MyCart findAll() {
        return this;
    }


    public void addProduct(Product product) {
        productList.add(product);
        System.out.println(productList);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productList=" + productList +
                '}';
    }
}
