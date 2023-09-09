package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.PromotionDetailDTO;
import com.duyhk.clothing_ecommerce.entity.PromotionDetail;

import java.util.List;

public interface PromotionDetailService {
    PromotionDetail convertToEntity(PromotionDetailDTO promotionDetailDTO);

    PromotionDetailDTO convertToDto(PromotionDetail promotionDetail);

    PageDTO<List<PromotionDetailDTO>> getAll(PageRequestDTO pageRequestDTO);

    PromotionDetailDTO getById(Long id);

    void create(PromotionDetailDTO promotionDetailDTO);

    void update(PromotionDetailDTO promotionDetailDTO);

    void delete(Long id);
}
