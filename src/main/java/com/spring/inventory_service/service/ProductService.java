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

    public Product updateStock(int id, int quantity){
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id: " + id));

        existingProduct.setStock(quantity);

        return productRepository.save(existingProduct);
    }
}
