package com.lucasferrari.inventory.service;

import com.lucasferrari.inventory.dto.ProductDTO;
import com.lucasferrari.inventory.dto.ProductionResultDTO;
import com.lucasferrari.inventory.entity.Product;
import com.lucasferrari.inventory.entity.ProductRawMaterial;
import com.lucasferrari.inventory.repository.ProductRawMaterialRepository;
import com.lucasferrari.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionService {

    private final ProductRepository productRepository;
    private final ProductRawMaterialRepository productRawMaterialRepository;

    public List<ProductionResultDTO> findProductsAvailableForProduction() {

        List<Product> products = productRepository.findAll();

        // Ordena por preço DESC (mais caro primeiro)
        products.sort((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));

        List<ProductionResultDTO> result = new ArrayList<>();

        for (Product product : products) {

            List<ProductRawMaterial> materials =
                    productRawMaterialRepository.findByProductId(product.getId());

            if (materials.isEmpty()) {
                continue;
            }

            Integer maxQuantity = Integer.MAX_VALUE;

            for (ProductRawMaterial prm : materials) {
                int possible =
                        prm.getRawMaterial().getStockQuantity() / prm.getRequiredQuantity();
                maxQuantity = Math.min(maxQuantity, possible);
            }

            if (maxQuantity <= 0) {
                continue;
            }

            BigDecimal totalValue =
                    product.getPrice().multiply(BigDecimal.valueOf(maxQuantity));

            result.add(
                    ProductionResultDTO.builder()
                            .productId(product.getId())
                            .productName(product.getName())
                            .unitPrice(product.getPrice())
                            .quantityToProduce(maxQuantity)
                            .totalValue(totalValue)
                            .build()
            );
        }

        return result;
    }
}
