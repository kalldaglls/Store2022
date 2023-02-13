package com.forgeeks.SpringDZ5.core.tests;


import com.forgeeks.SpringDZ5.core.entities.Category;
import com.forgeeks.SpringDZ5.core.entities.Product;
import com.forgeeks.SpringDZ5.core.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.core.repositories.ProductRep;
import com.forgeeks.SpringDZ5.core.service.CategoryService;
import com.forgeeks.SpringDZ5.core.service.ProductService;
import com.forgeeks.api.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ProductService.class)
//@DataJpaTest
public class ProductServiceTests {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRep productRepository;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void createNewProductTest() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Food");
        category.setProducts(Collections.emptyList());
        Mockito.doReturn(Optional.of(category))
                .when(categoryService)
                .findByTitle("Food");

        ProductDto productDto = new ProductDto(null, "Апельсины", BigDecimal.valueOf(100.0), "Food");
        productService.createNewProduct(productDto);

        System.out.println(Mockito.verify(productRepository, Mockito.times(1)).save(ArgumentMatchers.any()));
    }

    @Test
    public List<Product> findAllTest() {
       List<Product> products = new ArrayList<>();
       products.add(new Product(1l, BigDecimal.valueOf(100.0), new Category(), "Mojo"));
        Mockito.doReturn(Optional.of(products))
                .when(productRepository)
                .findAll();
        products =  productRepository.findAll();
        Mockito.verify(productRepository, Mockito.times(1)).findAll();
       return products;
    }

    @Test
    public void deleteById() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Food");
        category.setProducts(Collections.emptyList());
        Mockito.doReturn(Optional.of(category))
                .when(categoryService)
                .findByTitle("Food");

        ProductDto productDto = new ProductDto(1l, "Апельсины", BigDecimal.valueOf(100.0), "Food");
        productService.createNewProduct(productDto);
//        Mockito.doThrow(new ResourceNotFoundException("No such ID!"))
//                .when(productRepository)
//                .deleteById(1l);

        productService.deleteById(1l);
        Assertions.assertEquals(productDto.getId(), 1l);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(ArgumentMatchers.any());
    }
}
