package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.BillDetailDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.BillDetail;

import java.util.List;

public interface BillDetailService {
    BillDetail convertToEntity(BillDetailDTO billDetailDTO);

    BillDetailDTO convertToDto(BillDetail billDetail);

    PageDTO<List<BillDetailDTO>> getAll(PageRequestDTO pageRequestDTO);

    BillDetailDTO getById(Long id);

    void create(BillDetailDTO billDetailDTO);

    void update(BillDetailDTO billDetailDTO);

    void delete(Long id);
}
