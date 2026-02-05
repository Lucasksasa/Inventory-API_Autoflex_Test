package com.lucasferrari.inventory.repository;

import com.lucasferrari.inventory.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
}
