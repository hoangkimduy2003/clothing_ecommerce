package com.duyhk.clothing_ecommerce.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String email;
    private String password;
    private String passwordConfirm;
}
