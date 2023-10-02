package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.CategoryDetailDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.CategoryDetail;

import java.util.List;

public interface CategoryDetailService {
    CategoryDetail convertToEntity(CategoryDetailDTO categoryDetail);

    CategoryDetailDTO convertToDto(CategoryDetail categoryDetail);

    List<CategoryDetailDTO> getAll();

    PageDTO<List<CategoryDetailDTO>> getByPageRequest(PageRequestDTO pageRequestDTO);

    CategoryDetailDTO getById(Long id);

    void create(CategoryDetailDTO categoryDetail);

    void update(CategoryDetailDTO categoryDetail);

    void delete(Long id);
}
