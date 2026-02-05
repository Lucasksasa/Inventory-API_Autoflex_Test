package com.lucasferrari.inventory.service;


import com.lucasferrari.inventory.entity.Product;
import com.lucasferrari.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found, please confirm the existence of the ID"));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
