package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteDetailDTO {
    private Long id;
    @JsonIgnoreProperties("favouriteDetails")
    private ProductDetailDTO productDetail;
    @JsonIgnoreProperties("favouriteDetails")
    private FavouriteDTO favourite;
}
