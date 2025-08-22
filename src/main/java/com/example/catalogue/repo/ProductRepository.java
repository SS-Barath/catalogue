package com.example.catalogue.repo;
import com.example.catalogue.entity.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Long>{
  boolean existsBySku(String sku);
}
