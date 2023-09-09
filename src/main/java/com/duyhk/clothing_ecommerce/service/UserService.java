package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.UserDTO;
import com.duyhk.clothing_ecommerce.entity.Users;

import java.util.List;

public interface UserService {
    Users convertToEntity(UserDTO userDTO);

    UserDTO convertToDto(Users user);

    PageDTO<List<UserDTO>> getAll(PageRequestDTO pageRequestDTO);

    UserDTO getById(Long id);

    void create(UserDTO userDTO);

    void update(UserDTO userDTO);

    void delete(Long id);
}
