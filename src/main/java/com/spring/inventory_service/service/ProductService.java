package com.spring.inventory_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.inventory_service.dto.CreateProductDto;
import com.spring.inventory_service.dto.ResponseProductDto;
import com.spring.inventory_service.entity.Product;
import com.spring.inventory_service.mapper.ProductMapper;
import com.spring.inventory_service.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

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

    public ResponseProductDto saveNewProduct(CreateProductDto dto){
        Product product = productMapper.toProductEntity(dto);
        
        return productMapper.toResponseProductDto(productRepository.save(product));
    }

    public Product receiveNewShipment(int id, int quantity){
        Product existingProduct = getProductById(id);

        existingProduct.setStock(existingProduct.getStock() + quantity);

        return productRepository.save(existingProduct);
    }
}
