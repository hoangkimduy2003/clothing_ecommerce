package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.UserDTO;
import com.duyhk.clothing_ecommerce.entity.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Users convertToEntity(UserDTO userDTO);

    UserDTO convertToDto(Users user);

    List<UserDTO> getAll();

    PageDTO<List<UserDTO>> getByPageRequest(PageRequestDTO pageRequestDTO);

    UserDTO getById(Long id);

    Users findByEmail(String email);

    void create(UserDTO userDTO);

    void update(UserDTO userDTO);

    void delete(Long id);
}
