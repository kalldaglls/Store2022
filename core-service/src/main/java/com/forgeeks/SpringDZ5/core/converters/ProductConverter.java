package com.forgeeks.SpringDZ5.core.converters;

import com.forgeeks.SpringDZ5.core.entities.Category;
import com.forgeeks.SpringDZ5.core.entities.Product;
import com.forgeeks.api.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
//        System.out.println("DTO id: " + productDto.getId());
//        System.out.println("ProductDto: " + productDto);
//        Product product = new Product();
//        System.out.println("PROD id: " + product.getId());
//        product.setTitle(productDto.getTitle());
//        product.setPrice(productDto.getPrice());
//        product.setSecretKey(productDto.getSecretKey());
//        System.out.println(product);
        Category category = new Category();
        category.setTitle(productDto.getCategoryTitle());
        return new Product(productDto.getId(), productDto.getPrice(), category, productDto.getTitle());
    }

//    public ProductDto entityToDto(Product product) {
//        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getCategory().getTitle());
//    }

    public ProductDto entityToDto(Product p) {
        ProductDto productDto = new ProductDto();
        productDto.setId(p.getId());
        productDto.setTitle(p.getTitle());
        productDto.setPrice(p.getPrice());
        productDto.setCategoryTitle(p.getCategory().getTitle());
        return productDto;
    }

    public List<ProductDto> entityListToDtoList(List<Product> products){
        Iterator<Product> iterator = products.iterator();
        List<ProductDto> productDtoList = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setTitle(product.getTitle());
            productDto.setPrice(product.getPrice());
            productDto.setCategoryTitle(product.getCategory().getTitle());
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
