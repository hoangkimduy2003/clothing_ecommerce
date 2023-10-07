package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cartDetail")
public class CartDetailController {
    @Autowired
    private CartDetailService cartDetailService;

    @GetMapping("")
    public ResponseDTO<List<CartDetailDTO>> getAll() {
        return ResponseDTO.<List<CartDetailDTO>>builder()
                .data(cartDetailService.getAll())
                .status(200)
                .build();
    }

    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<CartDetailDTO>>> getByPageRequest(@RequestParam(name = "page", required = false) Integer page,
                                                                      @RequestParam(name = "size", required = false) Integer size) {
        return ResponseDTO.<PageDTO<List<CartDetailDTO>>>builder()
                .data(cartDetailService.getByPageRequest(new PageRequestDTO(page,size)))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<CartDetailDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<CartDetailDTO>builder()
                .status(200)
                .data(cartDetailService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody CartDetailDTO cartDetailDTO) {
        cartDetailService.create(cartDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm vào giỏ hàng thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody CartDetailDTO cartDetailDTO,
                                    @PathVariable Long id) {
        cartDetailDTO.setId(id);
        cartDetailService.update(cartDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa giỏ hàng thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        cartDetailService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá sản phẩm khỏi giỏ hàng thành công")
                .build();
    }
}
