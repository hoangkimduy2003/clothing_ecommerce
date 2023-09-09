package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.CartDetailDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.CartDetail;

import java.util.List;

public interface CartDetailService {
    CartDetail convertToEntity(CartDetailDTO cartDetailDTO);

    CartDetailDTO convertToDto(CartDetail cartDetail);

    PageDTO<List<CartDetailDTO>> getAll(PageRequestDTO pageRequestDTO);

    CartDetailDTO getById(Long id);

    void create(CartDetailDTO cartDetailDTO);

    void update(CartDetailDTO cartDetailDTO);

    void delete(Long id);
}
