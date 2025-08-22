// AttributeOptionCreateRequest.java
package com.example.catalogue.web.dto;
import jakarta.validation.constraints.*;
public record AttributeOptionCreateRequest(@NotBlank String value, @NotBlank String label) {}
