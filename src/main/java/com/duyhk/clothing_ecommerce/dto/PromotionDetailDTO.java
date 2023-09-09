package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDetailDTO {
    private Long id;
    @JsonIgnoreProperties("promotionDetails")
    private PromotionDTO promotion;
    @JsonIgnoreProperties("promotionDetails")
    private ProductDTO product;
}
