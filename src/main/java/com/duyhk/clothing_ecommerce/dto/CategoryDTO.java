package com.duyhk.clothing_ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private List<CategoryDetailDTO> categoryDetails;
}
