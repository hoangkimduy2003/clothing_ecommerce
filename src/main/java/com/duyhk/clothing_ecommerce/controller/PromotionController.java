package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.PromotionDTO;
import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import com.duyhk.clothing_ecommerce.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@CrossOrigin
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("")
    public ResponseDTO<PageDTO<List<PromotionDTO>>> getAll(@RequestBody PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<PromotionDTO>>>builder()
                .data(promotionService.getAll(pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<PromotionDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<PromotionDTO>builder()
                .status(200)
                .data(promotionService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody PromotionDTO promotionDTO) {
        promotionService.create(promotionDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm khuyến mại thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody PromotionDTO promotionDTO,
                                    @PathVariable Long id) {
        promotionDTO.setId(id);
        promotionService.update(promotionDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa khuyến mại thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        promotionService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá khuyến mại thành công")
                .build();
    }
}
