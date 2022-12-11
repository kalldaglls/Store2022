package com.forgeeks.SpringDZ5.core.repositories.specifications;

import com.forgeeks.SpringDZ5.core.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductsSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceLessThanOrEqualsThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }
    //Как LIKE в SQL!!!
    public static Specification<Product> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    public static Specification<Product> secretKeyLike(String secretKeyPart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("secretKey"), String.format("%%%s%%", secretKeyPart));
    }
}
