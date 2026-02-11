package com.lucasferrari.inventory.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductionResultDTO {

    private Long productId;
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantityToProduce;
    private BigDecimal totalValue;
}
