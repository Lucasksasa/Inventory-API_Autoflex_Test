package com.lucasferrari.inventory.service;

import com.lucasferrari.inventory.dto.ProductDTO;
import com.lucasferrari.inventory.entity.Product;
import com.lucasferrari.inventory.entity.ProductRawMaterial;
import com.lucasferrari.inventory.repository.ProductRawMaterialRepository;
import com.lucasferrari.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionService {

    private final ProductRepository productRepository;
    private final ProductRawMaterialRepository productRawMaterialRepository;

    public List<ProductDTO> findProductsAvailableForProduction() {

        List<Product> products = productRepository.findAll();
        List<ProductDTO> result = new ArrayList<>();

        for (Product product : products) {

            List<ProductRawMaterial> materials =
                    productRawMaterialRepository.findByProductId(product.getId());

            if (materials.isEmpty()) {
                continue;
            }

            boolean canProduce = true;

            for (ProductRawMaterial prm : materials) {
                if (prm.getRawMaterial().getStockQuantity() < prm.getRequiredQuantity()) {
                    canProduce = false;
                    break;
                }
            }

            if (canProduce) {
                result.add(
                        ProductDTO.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .price(product.getPrice())
                                .build()
                );
            }
        }

        return result;
    }
}
