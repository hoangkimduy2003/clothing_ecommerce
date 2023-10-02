package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.entity.Bill;

import java.util.List;

public interface BillService {
    Bill convertToEntity(BillDTO billDTO);

    BillDTO convertToDto(Bill bill);

    List<BillDTO> getAll();

    PageDTO<List<BillDTO>> getByPageRequest(PageRequestDTO pageRequestDTO);

    BillDTO getById(Long id);

    void create(BillDTO billDTO);

    void update(BillDTO billDTO);

    void delete(Long id);
}
