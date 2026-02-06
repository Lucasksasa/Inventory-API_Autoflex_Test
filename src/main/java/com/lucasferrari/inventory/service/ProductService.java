package com.lucasferrari.inventory.service;


import com.lucasferrari.inventory.dto.ProductDTO;
import com.lucasferrari.inventory.entity.Product;
import com.lucasferrari.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO save(ProductDTO dto) {
        Product product = Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();

        Product saved = productRepository.save(product);

        return ProductDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .price(saved.getPrice())
                .build();
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build())
                .toList();
    }

    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
