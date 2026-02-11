package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.ProductionResultDTO;
import com.lucasferrari.inventory.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production")
@RequiredArgsConstructor
public class ProductionController {

    @GetMapping("/available")
    public List<ProductionResultDTO> getAvailableProducts() {
        return productionService.findProductsAvailableForProduction();
    }

    private final ProductionService productionService;
}

