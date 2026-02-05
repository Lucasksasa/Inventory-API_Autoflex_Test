package com.lucasferrari.inventory.controller;

import com.lucasferrari.inventory.entity.RawMaterial;
import com.lucasferrari.inventory.service.RawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/raw-materials")
@RequiredArgsConstructor
public class RawMaterialController {
    private final RawMaterialService rawMaterialService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RawMaterial create(@RequestBody RawMaterial rawmaterial){
        return rawMaterialService.save(rawmaterial);
    }

    @GetMapping
    public List<RawMaterial> findAll(){
        return rawMaterialService.findAll();
    }

    @GetMapping("/{id}")
    public RawMaterial findById(@PathVariable Long id){
        return rawMaterialService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        rawMaterialService.delete(id);
    }
}
