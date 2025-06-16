package com.spring.inventory_service.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.inventory_service.dto.CreateProductDto;
import com.spring.inventory_service.dto.ResponseProductDto;
import com.spring.inventory_service.entity.Product;
import com.spring.inventory_service.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductContoller {
    
    private final ProductService service;

    @QueryMapping
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @QueryMapping
    public Product getProductById(@Argument Integer id){
        return service.getProductById(id);
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category){
        return service.getProductsByCategory(category);
    }

    @MutationMapping
    public ResponseProductDto saveNewProduct(@Argument CreateProductDto input){
        return service.saveNewProduct(input);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock){
        return service.updateStock(id, stock);
    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity){
        return service.receiveNewShipment(id, quantity);
    }
}
