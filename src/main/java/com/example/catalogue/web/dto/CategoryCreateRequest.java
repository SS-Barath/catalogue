// CategoryCreateRequest.java
package com.example.catalogue.web.dto;
import jakarta.validation.constraints.NotBlank;
public record CategoryCreateRequest(@NotBlank String name, @NotBlank String slug) {}
