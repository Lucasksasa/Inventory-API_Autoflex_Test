package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.RawMaterialDTO;
import com.lucasferrari.inventory.entity.RawMaterial;
import com.lucasferrari.inventory.service.RawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raw-materials")
@RequiredArgsConstructor
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    @PostMapping
    public RawMaterialDTO create(@RequestBody RawMaterialDTO dto) {

        RawMaterial rm = RawMaterial.builder()
                .id(dto.getId())
                .name(dto.getName())
                .stockQuantity(dto.getStockQuantity())
                .build();

        RawMaterial saved = rawMaterialService.save(rm);

        return RawMaterialDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .stockQuantity(saved.getStockQuantity())
                .build();
    }
}


