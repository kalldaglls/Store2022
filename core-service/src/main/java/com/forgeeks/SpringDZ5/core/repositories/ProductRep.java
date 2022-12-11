package com.forgeeks.SpringDZ5.core.repositories;

import com.forgeeks.SpringDZ5.core.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}
