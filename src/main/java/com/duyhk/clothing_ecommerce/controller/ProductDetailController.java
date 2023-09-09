package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ProductDetailDTO;
import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import com.duyhk.clothing_ecommerce.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productDetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("")
    public ResponseDTO<PageDTO<List<ProductDetailDTO>>> getAll(@RequestBody PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<ProductDetailDTO>>>builder()
                .data(productDetailService.getAll(pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<ProductDetailDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<ProductDetailDTO>builder()
                .status(200)
                .data(productDetailService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody ProductDetailDTO productDetailDTO) {
        productDetailService.create(productDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm chi tiết sản phẩm thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody ProductDetailDTO productDetailDTO,
                                    @PathVariable Long id) {
        productDetailDTO.setId(id);
        productDetailService.update(productDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa chi tiết sản phẩm thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        productDetailService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá chi tiết sản phẩm thành công")
                .build();
    }
}
