package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.FavouriteDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/favouriteDetail")
public class FavouriteDetailController {
    @Autowired
    private FavouriteDetailService favouriteDetailService;

    @GetMapping("")
    public ResponseDTO<List<FavouriteDetailDTO>> getAll() {
        return ResponseDTO.<List<FavouriteDetailDTO>>builder()
                .data(favouriteDetailService.getAll())
                .status(200)
                .build();
    }

    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<FavouriteDetailDTO>>> getByPageRequest(@RequestBody(required = false) PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<FavouriteDetailDTO>>>builder()
                .data(favouriteDetailService.getByPageRequest(pageRequestDTO == null ? new PageRequestDTO() : pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<FavouriteDetailDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<FavouriteDetailDTO>builder()
                .status(200)
                .data(favouriteDetailService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody FavouriteDetailDTO favouriteDetailDTO) {
        favouriteDetailService.create(favouriteDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm vào danh mục yêu thích thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody FavouriteDetailDTO favouriteDetailDTO,
                                    @PathVariable Long id) {
        favouriteDetailDTO.setId(id);
        favouriteDetailService.update(favouriteDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa danh mục yêu thích thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        favouriteDetailService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá sản phẩm khỏi danh mục yêu thích thành công")
                .build();
    }
}
