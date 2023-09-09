package com.duyhk.clothing_ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO extends TimeAuditableDTO{
    private Long id;
    private String fullName;
    private String addressDetail;
    private String phoneNumber;
    @JsonIgnoreProperties("addresses")
    private UserDTO user;
}
