package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {
    private Long id;

    private String name;
    private Double price;
    private Double priceSale;
    private Long quantity;
    private Long quantitySold;
    private Double averagedReview;
    private SizeDTO size;
    private ColorDTO color;
    @JsonIgnoreProperties("productDetails")
    private ProductDTO product;
    private List<CartDetailDTO> cartDetails;
    private List<BillDetailDTO> billDetails;
    private List<ReviewProductDTO> reviewProducts;
}
