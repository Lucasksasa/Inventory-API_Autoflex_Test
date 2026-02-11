package com.lucasferrari.inventory.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRawMaterialDTO {

    private Long productId;
    private Long rawMaterialId;
    private Integer requiredQuantity;
}
