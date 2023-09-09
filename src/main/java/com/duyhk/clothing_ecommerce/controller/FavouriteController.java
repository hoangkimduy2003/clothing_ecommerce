package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.FavouriteDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import com.duyhk.clothing_ecommerce.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/favourite")
public class FavouriteController {
    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("")
    public ResponseDTO<PageDTO<List<FavouriteDTO>>> getAll(@RequestBody PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<FavouriteDTO>>>builder()
                .data(favouriteService.getAll(pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<FavouriteDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<FavouriteDTO>builder()
                .status(200)
                .data(favouriteService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody FavouriteDTO favouriteDTO) {
        favouriteService.create(favouriteDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Tạo danh sách yêu thích thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody FavouriteDTO favouriteDTO,
                                    @PathVariable Long id) {
        favouriteDTO.setId(id);
        favouriteService.update(favouriteDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa danh sách yêu thích thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        favouriteService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá danh sách yêu thích thành công")
                .build();
    }
}
