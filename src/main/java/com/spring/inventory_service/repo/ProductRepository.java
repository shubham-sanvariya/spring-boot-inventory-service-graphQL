package com.spring.inventory_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.inventory_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
