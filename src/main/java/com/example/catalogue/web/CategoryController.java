// CategoryController.java
package com.example.catalogue.web;

import com.example.catalogue.entity.*;
import com.example.catalogue.service.CategoryService;
import com.example.catalogue.repo.CategoryRepository;
import com.example.catalogue.web.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/categories") @RequiredArgsConstructor
public class CategoryController {
  private final CategoryRepository categoryRepo;
  private final CategoryService service;

  @GetMapping public List<Category> all(){ return categoryRepo.findAll(); }

  @PostMapping public Category create(@Valid @RequestBody CategoryCreateRequest req){
    return service.createCategory(Category.builder().name(req.name()).slug(req.slug()).build());
  }

  @PostMapping("/{id}/attributes")
  public CategoryAttribute addAttribute(@PathVariable Long id, @Valid @RequestBody AttributeCreateRequest req){
    return service.addAttribute(id, req);
  }

  @PostMapping("/attributes/{attrId}/options")
  public CategoryAttributeOption addOption(@PathVariable Long attrId, @Valid @RequestBody AttributeOptionCreateRequest req){
    return service.addOption(attrId, req);
  }
}
