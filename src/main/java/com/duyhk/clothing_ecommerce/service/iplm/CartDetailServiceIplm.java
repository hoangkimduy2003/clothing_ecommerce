package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.entity.Bill;
import com.duyhk.clothing_ecommerce.entity.CartDetail;
import com.duyhk.clothing_ecommerce.reponsitory.CartDetailReponsitory;
import com.duyhk.clothing_ecommerce.service.CartDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartDetailServiceIplm implements CartDetailService {
    @Autowired
    private CartDetailReponsitory cartDetailRepo;
    @Override
    public CartDetail convertToEntity(CartDetailDTO cartDetailDTO) {
        return new ModelMapper().map(cartDetailDTO,CartDetail.class);
    }

    @Override
    public CartDetailDTO convertToDto(CartDetail cartDetail) {
        return new ModelMapper().map(cartDetail,CartDetailDTO.class);
    }
    @Override
    public List<CartDetailDTO> getAll() {
        return cartDetailRepo.findAll().stream().map(u -> convertToDto(u)).collect(Collectors.toList());
    }
    @Override
    public PageDTO<List<CartDetailDTO>> getByPageRequest(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<CartDetail> pageEntity = cartDetailRepo.findAll(
                PageRequest.of(
                        pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<CartDetailDTO> listDto = pageEntity.get().map(a -> convertToDto(a)).collect(Collectors.toList());
        return  PageDTO.<List<CartDetailDTO>>builder()
                .data(listDto)
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .build();
    }

    @Override
    public CartDetailDTO getById(Long id) {
        return convertToDto(cartDetailRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void create(CartDetailDTO cartDetail) {
        cartDetailRepo.save(convertToEntity(cartDetail));
    }

    @Override
    public void update(CartDetailDTO cartDetailDTO) {
        CartDetail cartDetail = cartDetailRepo.findById(cartDetailDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (cartDetail != null) {
            cartDetail = convertToEntity(cartDetailDTO);
            cartDetailRepo.save(cartDetail);
        }

    }

    @Override
    public void delete(Long id) {
        CartDetail bill = cartDetailRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        if (bill != null) {
            cartDetailRepo.deleteById(id);
        }
    }
}
