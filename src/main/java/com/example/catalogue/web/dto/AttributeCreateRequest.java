package com.example.catalogue.web.dto;

import com.example.catalogue.entity.enums.AttributeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AttributeCreateRequest(
        @NotBlank String name,
        @NotNull AttributeType attributeType
) {}
