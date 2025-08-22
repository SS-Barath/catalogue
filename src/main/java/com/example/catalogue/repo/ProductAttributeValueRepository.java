package com.example.catalogue.repo;
import com.example.catalogue.entity.*; import com.example.catalogue.entity.ids.ProductAttributeValueId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValue, ProductAttributeValueId> {}
