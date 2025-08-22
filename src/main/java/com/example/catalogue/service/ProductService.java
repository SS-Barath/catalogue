// ProductService.java
package com.example.catalogue.service;

import com.example.catalogue.entity.*;
import com.example.catalogue.exception.*;
import com.example.catalogue.repo.*;
import com.example.catalogue.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    @Transactional
    public Product create(ProductCreateRequest req) {
        Category cat = categoryRepo.findById(req.categoryId())
                .orElseThrow(() -> new NotFoundException("Category not found"));

        Product product = Product.builder()
                .name(req.name())
                .description(req.description())
                .category(cat)
                .build();

        return productRepo.save(product);
    }
}
