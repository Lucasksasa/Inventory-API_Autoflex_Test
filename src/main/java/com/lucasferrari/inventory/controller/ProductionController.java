package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.ProductDTO;
import com.lucasferrari.inventory.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production")
@RequiredArgsConstructor
public class ProductionController {

    @GetMapping("/available")
    public List<ProductDTO> getAvailableProducts() {
        return productionService.findProductsAvailableForProduction();
    }

    private final ProductionService productionService;
}

