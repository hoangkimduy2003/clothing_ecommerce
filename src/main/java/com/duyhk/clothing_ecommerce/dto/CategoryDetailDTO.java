package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailDTO {
    private Long id;
    private String name;
    @JsonIgnoreProperties("categoryDetails")
    private CategoryDTO category;
    @JsonIgnore
    private List<ProductDTO> products;
}
