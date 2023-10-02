package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.PromotionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotionDetail")
public class PromotionDetailController {
    @Autowired
    private PromotionDetailService promotionDetailService;

    @GetMapping("")
    public ResponseDTO<List<PromotionDetailDTO>> getAll() {
        return ResponseDTO.<List<PromotionDetailDTO>>builder()
                .data(promotionDetailService.getAll())
                .status(200)
                .build();
    }

    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<PromotionDetailDTO>>> getByPageRequest(@RequestBody(required = false) PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<PromotionDetailDTO>>>builder()
                .data(promotionDetailService.getByPageRequest(pageRequestDTO == null ? new PageRequestDTO() : pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<PromotionDetailDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<PromotionDetailDTO>builder()
                .status(200)
                .data(promotionDetailService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody PromotionDetailDTO promotionDetailDTO) {
        promotionDetailService.create(promotionDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm chi tiết khuyến mại thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody PromotionDetailDTO promotionDetailDTO,
                                    @PathVariable Long id) {
        promotionDetailDTO.setId(id);
        promotionDetailService.update(promotionDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa chi tiết khuyến mại thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        promotionDetailService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá chi tiết khuyến mại thành công")
                .build();
    }
}
