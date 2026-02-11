package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.ProductDTO;
import com.lucasferrari.inventory.entity.Product;
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

        Product product = Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();

        Product saved = productService.save(product);

        return ProductDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .price(saved.getPrice())
                .build();
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll()
                .stream()
                .map(p -> ProductDTO.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .price(p.getPrice())
                        .build())
                .toList();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        Product p = productService.findById(id);
        return ProductDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}

