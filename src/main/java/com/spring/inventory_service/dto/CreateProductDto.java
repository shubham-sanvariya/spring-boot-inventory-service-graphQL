package com.spring.inventory_service.dto;

public record CreateProductDto(
        String name,
        String category,
        Float price,
        Integer stock
) {
}