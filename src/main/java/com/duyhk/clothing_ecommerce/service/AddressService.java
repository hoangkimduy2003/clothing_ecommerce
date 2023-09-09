package com.duyhk.clothing_ecommerce.service;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.Address;
import com.duyhk.clothing_ecommerce.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    Address convertToEntity(AddressDTO addressDTO);

    AddressDTO convertToDto(Address address);

    PageDTO<List<AddressDTO>> getAll(PageRequestDTO pageRequestDTO);

    AddressDTO getById(Long id);

    void create(AddressDTO addressDTO);

    void update(AddressDTO addressDTO);

    void delete(Long id);
}
