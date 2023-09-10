package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ProductDTO;
import com.duyhk.clothing_ecommerce.dto.PromotionDetailDTO;
import com.duyhk.clothing_ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product convertToEntity(ProductDTO productDTO);

    ProductDTO convertToDto(Product product);
    List<ProductDTO> getAll();
    PageDTO<List<ProductDTO>> getByPageRequest(PageRequestDTO pageRequestDTO);

    ProductDTO getById(Long id);

    void create(ProductDTO productDTO);

    void update(ProductDTO productDTO);

    void delete(Long id);
}
