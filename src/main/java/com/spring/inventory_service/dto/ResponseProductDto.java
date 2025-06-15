package com.spring.inventory_service.dto;

public record ResponseProductDto(
        Integer id,
        String name,
        String category,
        Float price,
        Integer stock) {}
