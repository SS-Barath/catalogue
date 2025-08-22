// ids/ProductAttributeValueId.java
package com.example.catalogue.entity.ids;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable @Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class ProductAttributeValueId implements Serializable {
  private Long productId;
  private Long attributeId;
}
