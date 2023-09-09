package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDetailDTO {
    private Long id;
    @JsonIgnoreProperties("billDetails")
    private ProductDetailDTO productDetail;
    @JsonIgnoreProperties("billDetails")
    private BillDTO bill;
}
