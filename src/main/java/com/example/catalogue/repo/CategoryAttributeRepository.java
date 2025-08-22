package com.example.catalogue.repo;
import com.example.catalogue.entity.*; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute,Long>{
  List<CategoryAttribute> findByCategoryId(Long categoryId);
}
