// CategoryAttributeOption.java
package com.example.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="category_attribute_options",
       uniqueConstraints=@UniqueConstraint(name="uq_attr_option",columnNames={"attribute_id","value"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryAttributeOption {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="attribute_id",nullable=false) @JsonIgnore
  private CategoryAttribute attribute;

  @Column(nullable=false,length=120) private String value;
  @Column(nullable=false,length=120) private String label;
}
