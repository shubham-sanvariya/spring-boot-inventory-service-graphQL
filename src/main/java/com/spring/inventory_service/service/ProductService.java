package com.spring.inventory_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.inventory_service.entity.Product;
import com.spring.inventory_service.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    

    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }
}
