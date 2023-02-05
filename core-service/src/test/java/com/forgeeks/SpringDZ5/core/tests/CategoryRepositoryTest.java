package com.forgeeks.SpringDZ5.core.tests;

import com.forgeeks.SpringDZ5.core.entities.Category;
import com.forgeeks.SpringDZ5.core.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;


import java.util.Collections;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAllCategoriesTest() {
        Category category = new Category();
        category.setTitle("Электроника");
        category.setProducts(Collections.emptyList());
        entityManager.persist(category);
        entityManager.flush();

        List<Category> categoriesList = categoryRepository.findAll();
        Assertions.assertEquals(2, categoriesList.size());
        Assertions.assertEquals("Food", categoriesList.get(0).getTitle());
    }
}
