package com.lucasferrari.inventory.service;

import com.lucasferrari.inventory.dto.ProductRawMaterialDTO;
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

    public ProductRawMaterialDTO linkRawMaterialToProduct(
            Long productId,
            Long rawMaterialId,
            Integer requiredQuantity
    ) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        RawMaterial rawMaterial = rawMaterialRepository.findById(rawMaterialId)
                .orElseThrow(() -> new RuntimeException("Raw material not found"));

        ProductRawMaterial prm = ProductRawMaterial.builder()
                .product(product)
                .rawMaterial(rawMaterial)
                .requiredQuantity(requiredQuantity)
                .build();

        ProductRawMaterial saved = productRawMaterialRepository.save(prm);

        return ProductRawMaterialDTO.builder()
                .productId(saved.getProduct().getId())
                .rawMaterialId(saved.getRawMaterial().getId())
                .requiredQuantity(saved.getRequiredQuantity())
                .build();
    }
}
