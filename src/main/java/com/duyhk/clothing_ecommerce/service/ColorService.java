package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.ColorDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.Color;

import java.util.List;

public interface ColorService {
    Color convertToEntity(ColorDTO colorDTO);

    ColorDTO convertToDto(Color color);

    PageDTO<List<ColorDTO>> getAll(PageRequestDTO pageRequestDTO);

    ColorDTO getById(Long id);

    void create(ColorDTO colorDTO);

    void update(ColorDTO colorDTO);

    void delete(Long id);
}
