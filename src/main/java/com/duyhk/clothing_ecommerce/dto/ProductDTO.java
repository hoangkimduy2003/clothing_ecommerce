package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends TimeAuditableDTO {
    private Long id;
    private String name;
    private Double importPrice;
    private Double price;
    private Double priceSale;
    private Long totalQuantitySold;
    private Long totalQuantity;
    private String description;
    private Long status;
    private List<String> images;
    @JsonIgnoreProperties("products")
    private CategoryDetailDTO category;
    private List<PromotionDetailDTO> promotionDetails;
    private List<ProductDetailDTO> productDetails;
    @JsonIgnore
    private List<MultipartFile> filesUpload;
}
