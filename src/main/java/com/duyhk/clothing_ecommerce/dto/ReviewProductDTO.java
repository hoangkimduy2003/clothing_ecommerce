package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewProductDTO extends TimeAuditableDTO{
    private Long id;
    private Double rating;
    private String description;
    @JsonIgnoreProperties("reviewProducts")
    private ProductDetailDTO productDetail;
    @JsonIgnoreProperties("reviewProducts")
    private UserDTO user;
}
