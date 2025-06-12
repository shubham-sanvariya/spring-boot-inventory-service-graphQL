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

    public Product getProductById(int id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id: " + id));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public Product updateStock(int id, int stock){
        Product existingProduct = getProductById(id);

        existingProduct.setStock(stock);

        return productRepository.save(existingProduct);
    }

    public Product receiveNewShipment(int id, int stock){
        Product existingProduct = getProductById(id);

        existingProduct.setStock(existingProduct.getStock() + stock);

        return productRepository.save(existingProduct);
    }
}
