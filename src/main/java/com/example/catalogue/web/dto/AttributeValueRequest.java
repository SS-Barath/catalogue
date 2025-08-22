// AttributeValueRequest.java
package com.example.catalogue.web.dto;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record AttributeValueRequest(
  @NotNull Long attributeId,
  String valueStr, BigDecimal valueNum, Boolean valueBool, String valueJson) {}
