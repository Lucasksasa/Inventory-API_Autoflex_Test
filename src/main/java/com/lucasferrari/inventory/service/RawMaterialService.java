package com.lucasferrari.inventory.service;

import com.lucasferrari.inventory.dto.RawMaterialDTO;
import com.lucasferrari.inventory.entity.RawMaterial;
import com.lucasferrari.inventory.repository.RawMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;

    public RawMaterialDTO save(RawMaterialDTO dto) {
        RawMaterial rawMaterial = RawMaterial.builder()
                .id(dto.getId())
                .name(dto.getName())
                .stockQuantity(dto.getStockQuantity())
                .build();

        RawMaterial saved = rawMaterialRepository.save(rawMaterial);

        return RawMaterialDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .stockQuantity(saved.getStockQuantity())
                .build();
    }

    public List<RawMaterialDTO> findAll() {
        return rawMaterialRepository.findAll()
                .stream()
                .map(rm -> RawMaterialDTO.builder()
                        .id(rm.getId())
                        .name(rm.getName())
                        .stockQuantity(rm.getStockQuantity())
                        .build())
                .toList();
    }

    public RawMaterialDTO findById(Long id) {
        RawMaterial rm = rawMaterialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raw material not found"));

        return RawMaterialDTO.builder()
                .id(rm.getId())
                .name(rm.getName())
                .stockQuantity(rm.getStockQuantity())
                .build();
    }

    public void delete(Long id) {
        rawMaterialRepository.deleteById(id);
    }
}