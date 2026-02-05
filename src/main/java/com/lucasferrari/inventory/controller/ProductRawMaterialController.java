package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.entity.ProductRawMaterial;
import com.lucasferrari.inventory.service.ProductRawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-raw-materials")
@RequiredArgsConstructor
public class ProductRawMaterialController {

    private final ProductRawMaterialService productRawMaterialService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductRawMaterial link (
            @RequestParam Long productId,
            @RequestParam Long rawMaterialId,
            @RequestParam Integer requiredQuantity
    ){
        return productRawMaterialService
                .linkRawMaterialToProduct(productId, rawMaterialId, requiredQuantity);
    }

    @GetMapping("/product/{productId}")

    public List <ProductRawMaterial> findByProduct(@PathVariable Long productId){
        return productRawMaterialService.findByProduct(productId);
    }

}

