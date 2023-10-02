package com.duyhk.clothing_ecommerce.dto;

import com.duyhk.clothing_ecommerce.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends TimeAuditableDTO {
    private Long id;
    private String password;
    private String email;
    private String image;
    private Role role;
    private Integer status;
    private List<AddressDTO> addresses;
    private List<ReviewProductDTO> reviewProducts;
    private List<BillDTO> bills;
    private CartDTO cart;
    private FavouriteDTO favourite;
}
