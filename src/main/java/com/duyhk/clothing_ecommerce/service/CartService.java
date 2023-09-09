package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.CartDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.Cart;

import java.util.List;

public interface CartService {
    Cart convertToEntity(CartDTO cartDTO);

    CartDTO convertToDto(Cart cart);

    PageDTO<List<CartDTO>> getAll(PageRequestDTO pageRequestDTO);

    CartDTO getById(Long id);

    void create(CartDTO cartDTO);

    void update(CartDTO cartDTO);

    void delete(Long id);
}
