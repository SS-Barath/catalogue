// ProductController.java
package com.example.catalogue.web;

import com.example.catalogue.entity.Product;
import com.example.catalogue.service.ProductService;
import com.example.catalogue.web.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product create(@RequestBody ProductCreateRequest req) {
        return service.create(req);
    }
}
