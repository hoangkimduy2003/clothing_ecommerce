package com.duyhk.clothing_ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
