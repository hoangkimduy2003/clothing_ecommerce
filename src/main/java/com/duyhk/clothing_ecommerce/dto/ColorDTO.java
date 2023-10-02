package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorDTO extends TimeAuditableDTO {
    private Long id;
    @NotNull(message = "${message.err.nameColor}")
    @NotBlank(message = "${message.err.nameColor}")
    private String name;
    @JsonIgnore
    private List<ProductDetailDTO> productDetails;
}
