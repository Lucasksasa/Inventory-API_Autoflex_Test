package com.lucasferrari.inventory.repository;

import com.lucasferrari.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
