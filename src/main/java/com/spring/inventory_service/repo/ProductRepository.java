package com.spring.inventory_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.inventory_service.entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{
    
    List<Product> findByCategory(String category);
}
