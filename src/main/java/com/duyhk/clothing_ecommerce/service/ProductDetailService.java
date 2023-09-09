package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ProductDetailDTO;
import com.duyhk.clothing_ecommerce.entity.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    ProductDetail convertToEntity(ProductDetailDTO productDetailDTO);

    ProductDetailDTO convertToDto(ProductDetail productDetail);

    PageDTO<List<ProductDetailDTO>> getAll(PageRequestDTO pageRequestDTO);

    ProductDetailDTO getById(Long id);

    void create(ProductDetailDTO productDetailDTO);

    void update(ProductDetailDTO productDetailDTO);

    void delete(Long id);
}
