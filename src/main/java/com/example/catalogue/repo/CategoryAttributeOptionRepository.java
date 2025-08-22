package com.example.catalogue.repo;
import com.example.catalogue.entity.*; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CategoryAttributeOptionRepository extends JpaRepository<CategoryAttributeOption,Long>{
  List<CategoryAttributeOption> findByAttributeId(Long attributeId);
}
