package com.example.catalogue.web.dto;

public record ProductCreateRequest(
        String name,
        String description,
        Long categoryId
) {}
