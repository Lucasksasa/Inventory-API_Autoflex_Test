package com.lucasferrari.inventory.service;

import com.lucasferrari.inventory.entity.RawMaterial;
import com.lucasferrari.inventory.repository.RawMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterial save(RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    public List<RawMaterial> findAll() {
        return rawMaterialRepository.findAll();
    }

    public RawMaterial findById(Long id) {
        return rawMaterialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found"));
    }

    public void delete(Long id) {
        rawMaterialRepository.deleteById(id);
    }
}