package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.dto.RawMaterialDTO;
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
        return rawMaterialService.save(dto);
    }

    @GetMapping
    public List<RawMaterialDTO> findAll() {
        return rawMaterialService.findAll();
    }

    @GetMapping("/{id}")
    public RawMaterialDTO findById(@PathVariable Long id) {
        return rawMaterialService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rawMaterialService.delete(id);
    }
}

