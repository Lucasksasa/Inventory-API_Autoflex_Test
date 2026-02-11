package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.ProductRawMaterialDTO;
import com.lucasferrari.inventory.service.ProductRawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-raw-materials")
@RequiredArgsConstructor
public class ProductRawMaterialController {

    private final ProductRawMaterialService productRawMaterialService;

    @PostMapping
    public ProductRawMaterialDTO link(
            @RequestParam Long productId,
            @RequestParam Long rawMaterialId,
            @RequestParam Integer requiredQuantity
    ) {
        return productRawMaterialService
                .linkRawMaterialToProduct(productId, rawMaterialId, requiredQuantity);
    }

    @GetMapping("/product/{productId}")
    public List<ProductRawMaterialDTO> findByProduct(@PathVariable Long productId) {
        return productRawMaterialService.findByProductId(productId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productRawMaterialService.delete(id);
    }
}


