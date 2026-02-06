package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.ProductDTO;
import com.lucasferrari.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO dto) {
        return productService.save(dto);
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}

