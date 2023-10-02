package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseDTO<List<ProductDTO>> getAll() {
        return ResponseDTO.<List<ProductDTO>>builder()
                .data(productService.getAll())
                .status(200)
                .build();
    }

    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<ProductDTO>>> getByPageRequest(@RequestBody(required = false) PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<ProductDTO>>>builder()
                .data(productService.getByPageRequest(pageRequestDTO == null ? new PageRequestDTO() : pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<ProductDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<ProductDTO>builder()
                .status(200)
                .data(productService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm sản phẩm thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody ProductDTO productDTO,
                                    @PathVariable Long id) {
        productDTO.setId(id);
        productService.update(productDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa sản phẩm thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        productService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá sản phẩm thành công")
                .build();
    }
}
