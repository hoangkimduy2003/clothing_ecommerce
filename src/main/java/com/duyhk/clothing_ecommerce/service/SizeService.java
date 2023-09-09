package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.SizeDTO;
import com.duyhk.clothing_ecommerce.entity.Size;

import java.util.List;

public interface SizeService {
    Size convertToEntity(SizeDTO sizeDTO);

    SizeDTO convertToDto(Size size);

    PageDTO<List<SizeDTO>> getAll(PageRequestDTO pageRequestDTO);

    SizeDTO getById(Long id);

    void create(SizeDTO sizeDTO);

    void update(SizeDTO sizeDTO);

    void delete(Long id);
}
