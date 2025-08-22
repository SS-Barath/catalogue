package com.example.catalogue.service;

import com.example.catalogue.entity.Category;
import com.example.catalogue.entity.CategoryAttribute;
import com.example.catalogue.repository.CategoryRepository;
import com.example.catalogue.web.dto.AttributeCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public void addAttribute(Long categoryId, AttributeCreateRequest req) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        CategoryAttribute attribute = CategoryAttribute.builder()
                .name(req.name())
                .attributeType(req.attributeType())   // fixed here ✅
                .category(category)
                .build();

        category.getAttributes().add(attribute);
        categoryRepository.save(category);
    }
}
