package com.duyhk.clothing_ecommerce.service.iplm;

import com.duyhk.clothing_ecommerce.dto.CartDTO;
import com.duyhk.clothing_ecommerce.dto.CartDetailDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.entity.Cart;
import com.duyhk.clothing_ecommerce.entity.CartDetail;
import com.duyhk.clothing_ecommerce.reponsitory.CartReponsitory;
import com.duyhk.clothing_ecommerce.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceIplm implements CartService {
    @Autowired
    private CartReponsitory cartRepo;

    @Override
    public Cart convertToEntity(CartDTO cartDTO) {
        return new ModelMapper().map(cartDTO,Cart.class);
    }

    @Override
    public CartDTO convertToDto(Cart cart) {
        return new ModelMapper().map(cart,CartDTO.class);
    }

    @Override
    public PageDTO<List<CartDTO>> getAll(PageRequestDTO pageRequestDTO) {
        pageRequestDTO.setPage(pageRequestDTO.getPage() == null ? 0 : pageRequestDTO.getPage());
        pageRequestDTO.setSize(pageRequestDTO.getSize() == null ? 5 : pageRequestDTO.getSize());
        Page<Cart> pageEntity = cartRepo.findAll(
                PageRequest.of(
                        pageRequestDTO.getPage(),
                        pageRequestDTO.getSize()));
        List<CartDTO> listDto = pageEntity.get().map(a -> convertToDto(a)).collect(Collectors.toList());
        return  PageDTO.<List<CartDTO>>builder()
                .data(listDto)
                .totalElements(pageEntity.getTotalElements())
                .totalPages(pageEntity.getTotalPages())
                .build();
    }

    @Override
    public CartDTO getById(Long id) {
        return convertToDto(cartRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void create(CartDTO cartDTO) {
        cartRepo.save(convertToEntity(cartDTO));
    }

    @Override
    public void update(CartDTO cartDTO) {
        Cart cart = cartRepo.findById(cartDTO.getId()).orElseThrow(IllegalArgumentException::new);
        if (cart != null) {
            cart = convertToEntity(cartDTO);
            cartRepo.save(cart);
        }

    }

    @Override
    public void delete(Long id) {
        Cart cart = cartRepo.findById(id).orElseThrow(IllegalArgumentException::new);
        if (cart != null) {
            cartRepo.deleteById(id);
        }
    }
}
