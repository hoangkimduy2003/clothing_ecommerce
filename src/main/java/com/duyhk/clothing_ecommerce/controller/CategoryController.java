package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.CategoryDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import com.duyhk.clothing_ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseDTO<PageDTO<List<CategoryDTO>>> getAll(@RequestBody PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<CategoryDTO>>>builder()
                .data(categoryService.getAll(pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<CategoryDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<CategoryDTO>builder()
                .status(200)
                .data(categoryService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm loại sản phẩm thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody CategoryDTO categoryDTO,
                                    @PathVariable Long id) {
        categoryDTO.setId(id);
        categoryService.update(categoryDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa loại sản phẩm thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá loại sản phẩm thành công")
                .build();
    }
}
