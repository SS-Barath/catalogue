// ProductAttributeValue.java
package com.example.catalogue.entity;

import com.example.catalogue.entity.ids.ProductAttributeValueId;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name="product_attribute_values")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductAttributeValue {
  @EmbeddedId private ProductAttributeValueId id;

  @ManyToOne(fetch=FetchType.LAZY) @MapsId("productId") @JoinColumn(name="product_id")
  private Product product;

  @ManyToOne(fetch=FetchType.LAZY) @MapsId("attributeId") @JoinColumn(name="attribute_id")
  private CategoryAttribute attribute;

  @Column(name="value_str", length=1000) private String valueStr;
  @Column(name="value_num", precision=38, scale=6) private BigDecimal valueNum;
  @Column(name="value_bool") private Boolean valueBool;
  @Column(name="value_json", columnDefinition="JSON") private String valueJson;
}
