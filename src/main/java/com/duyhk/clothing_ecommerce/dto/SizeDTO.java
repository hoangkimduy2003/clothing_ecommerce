package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SizeDTO extends TimeAuditableDTO {
    private Long id;
    private String name;
    @JsonIgnore
    private List<ProductDetailDTO> productDetails;
}
