package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailDTO {
    private Long id;
    private Long quantity;
    @JsonIgnoreProperties("cartDetails")
    private ProductDetailDTO productDetail;
    @JsonIgnoreProperties("cartDetails")
    private CartDTO cart;
}
