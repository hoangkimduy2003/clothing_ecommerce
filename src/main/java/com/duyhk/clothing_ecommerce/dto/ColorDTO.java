package com.duyhk.clothing_ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorDTO extends TimeAuditableDTO{
    private Long id;
    private String name;
    private List<ProductDetailDTO> productDetails;
}
