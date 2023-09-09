package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.BillDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.Bill;

import java.util.List;

public interface BillService {
    Bill convertToEntity(BillDTO billDTO);

    BillDTO convertToDto(Bill bill);

    PageDTO<List<BillDTO>> getAll(PageRequestDTO pageRequestDTO);

    BillDTO getById(Long id);

    void create(BillDTO billDTO);

    void update(BillDTO billDTO);

    void delete(Long id);
}
