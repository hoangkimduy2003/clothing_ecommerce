package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.CategoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categoryDetail")
public class CategoryDetailController {

    @Autowired
    private CategoryDetailService categoryDetailService;

    @GetMapping("")
    public ResponseDTO<List<CategoryDetailDTO>> getAll() {
        return ResponseDTO.<List<CategoryDetailDTO>>builder()
                .data(categoryDetailService.getAll())
                .status(200)
                .build();
    }

    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<CategoryDetailDTO>>> getByPageRequest(@RequestParam(name = "page", required = false) Integer page,
                                                                          @RequestParam(name = "size", required = false) Integer size) {
        return ResponseDTO.<PageDTO<List<CategoryDetailDTO>>>builder()
                .data(categoryDetailService.getByPageRequest(new PageRequestDTO(page,size)))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<CategoryDetailDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<CategoryDetailDTO>builder()
                .status(200)
                .data(categoryDetailService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody CategoryDetailDTO categoryDetail) {
        categoryDetailService.create(categoryDetail);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm loại sản phẩm thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody CategoryDetailDTO categoryDetail,
                                    @PathVariable Long id) {
        categoryDetail.setId(id);
        categoryDetailService.update(categoryDetail);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa loại sản phẩm thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        categoryDetailService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá loại sản phẩm thành công")
                .build();
    }
}
