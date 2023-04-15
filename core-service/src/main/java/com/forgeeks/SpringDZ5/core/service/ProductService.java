package com.forgeeks.SpringDZ5.core.service;

import com.forgeeks.SpringDZ5.core.entities.Category;
import com.forgeeks.SpringDZ5.core.entities.Product;
import com.forgeeks.SpringDZ5.core.exceptions.ResourceNotFoundException;
import com.forgeeks.SpringDZ5.core.repositories.ProductRep;
import com.forgeeks.SpringDZ5.core.repositories.specifications.ProductsSpecifications;
import com.forgeeks.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRep productRep;
    private final CategoryService categoryService;
//    private final RedisTemplate<Long, Product> redisTemplate;
//    private final List<Optional<Product>> productList = new ArrayList<>();

    public Page<Product> find(Integer minPrice, Integer maxPrice, String titlePart, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null){
            spec = spec.and(ProductsSpecifications.priceGreaterOrEqualsThan(minPrice));
        }

        if (maxPrice != null){
            spec = spec.and(ProductsSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }

        if (titlePart != null){
            spec = spec.and(ProductsSpecifications.titleLike(titlePart));
        }

        return productRep.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public List<Product> findAll() {
        return productRep.findAll();
    }

    public void deleteById(Long id) {
        productRep.deleteById(id);
    }

    public void createNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("Категория с названием: " + productDto.getCategoryTitle() + " не найдена")));
        productRep.save(product);
//        redisTemplate.opsForValue().set(product.getProductId(), product);
    }
    public Product save(Product product) {
        return productRep.save(product);
    }

    //    @Autowired
//    public void setProductRep(ProductRep productRep) {
//        this.productRep = productRep;
//    }
//
//    public Product getProductById(int id) {
//        return productRep.findOneById(id);
//    }
//
//    public ProductRep getProductRep() {
//        return productRep;
//    }
//


    public Optional<Product> findById(Long id) {
        return productRep.findById(id);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRep.findById(productDto.getId()).orElseThrow(() -> new RuntimeException("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = new Category();
        category.setTitle(productDto.getCategoryTitle());
        product.setCategory(category);
        return product;
    }

//    public  List<Optional<Product>> putToCartById(Long id) {
//        productList.add(productRep.findById(id));
//        System.out.println(productList);
//        return productList;
//    }
}
