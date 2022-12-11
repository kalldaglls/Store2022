package com.forgeeks.SpringDZ5.core.service;

import com.forgeeks.SpringDZ5.core.entities.Category;
import com.forgeeks.SpringDZ5.core.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
