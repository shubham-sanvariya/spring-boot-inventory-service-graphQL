package com.spring.inventory_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.inventory_service.dto.CreateProductDto;
import com.spring.inventory_service.dto.ResponseProductDto;
import com.spring.inventory_service.entity.Product;

@Mapper
public interface ProductMapper {
    
    @Mapping(target = "id", ignore = true)
    Product toProductEntity(CreateProductDto dto);

    ResponseProductDto toResponseProductDto(Product product);
}
