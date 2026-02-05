package com.lucasferrari.inventory.service;

import com.lucasferrari.inventory.entity.Product;
import com.lucasferrari.inventory.entity.ProductRawMaterial;
import com.lucasferrari.inventory.entity.RawMaterial;
import com.lucasferrari.inventory.repository.ProductRawMaterialRepository;
import com.lucasferrari.inventory.repository.ProductRepository;
import com.lucasferrari.inventory.repository.RawMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRawMaterialService {

    private final ProductRawMaterialRepository productRawMaterialRepository;
    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;

    public ProductRawMaterial linkRawMaterialToProduct(
            Long productId,
            Long rawMaterialId,
            Integer requiredQuantity
    ) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found, please confirm the existence of the ID"));

        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId)
                .orElseThrow(() -> new RuntimeException("Raw material not found, please confirm the existence of the ID"));

        ProductRawMaterial productRawMaterial = ProductRawMaterial.builder()
                .product(product)
                .rawMaterial(rawMaterial)
                .requiredQuantity(requiredQuantity)
                .build();

        return productRawMaterialRepository.save(productRawMaterial);
    }

    public List<ProductRawMaterial> findByProduct(Long productId) {
        return productRawMaterialRepository.findByProductId(productId);
    }
}
